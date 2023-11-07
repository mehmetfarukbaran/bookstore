package com.mehmetfaruk.bookstore.book.model;

import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public BookDAO toDAO(Book book){
        if (book == null) {
            return null;
        }

        BookDAO bookDAO = new BookDAO();
        bookDAO.setIsbn(book.getIsbn());
        bookDAO.setPrice(book.getPrice());
        bookDAO.setAuthor(book.getAuthor());
        bookDAO.setTitle(book.getTitle());
        bookDAO.setStockQuantity(book.getStockQuantity());

        return bookDAO;
    }

    public Book toEntity(BookDAO bookDAO){
        if (bookDAO == null) {
            return null;
        }

        Book book = new Book();

        book.setIsbn(bookDAO.getIsbn());
        book.setPrice(bookDAO.getPrice());
        book.setAuthor(bookDAO.getAuthor());
        book.setTitle(bookDAO.getTitle());
        book.setStockQuantity(bookDAO.getStockQuantity());

        return book;
    }
}
