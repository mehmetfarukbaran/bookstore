package com.mehmetfaruk.bookstore.book.service;

import com.mehmetfaruk.bookstore.book.model.BookDAO;
import com.mehmetfaruk.bookstore.book.repo.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    // TODO: 7.11.2023 will provide paging
    public List<BookDAO> getBooks(){
        return null;
    }

    public BookDAO getBookByIsbn(Long isbn){
        return null;
    }

    public BookDAO saveBook(BookDAO book){
        return null;
    }

    public BookDAO updateBook(Long isbn){
        return null;
    }

    public Boolean deleteBook(Long isbn){
        return null;
    }

}
