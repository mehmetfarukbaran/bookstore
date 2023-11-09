package com.mehmetfaruk.bookstore.book.service;

import com.mehmetfaruk.bookstore.book.model.Book;
import com.mehmetfaruk.bookstore.book.model.BookDAO;
import com.mehmetfaruk.bookstore.book.model.BookMapper;
import com.mehmetfaruk.bookstore.book.repo.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public List<BookDAO> getBooks(Pageable pageable){
        return bookRepository.findByOrderByCreatedDateDesc(pageable).map(bookMapper::toDAO).stream().toList();
    }

    public BookDAO getBookByIsbn(Long isbn){
        return bookMapper.toDAO(bookRepository.findByIsbn(isbn));
    }

    public BookDAO saveBook(BookDAO bookDAO){
        return bookMapper.toDAO(bookRepository.save(bookMapper.toEntity(bookDAO)));
    }

    public BookDAO updateBook(Long isbn, BookDAO bookDAO) throws Exception {
        Book book = bookRepository.findByIsbn(isbn);
        if (book == null){
            throw new Exception("Book not found.");
        }

        book.setStockQuantity(bookDAO.getStockQuantity());
        book.setAuthor(bookDAO.getAuthor());
        book.setTitle(bookDAO.getTitle());
        book.setPrice(bookDAO.getPrice());

        return bookMapper.toDAO(bookRepository.save(book));
    }

    public void deleteBook(Long isbn){
        bookRepository.deleteByIsbn(isbn);
    }

}
