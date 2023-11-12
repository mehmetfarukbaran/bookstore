package com.mehmetfaruk.bookstore.builder;

import com.mehmetfaruk.bookstore.book.model.BookDAO;
import lombok.NoArgsConstructor;
import org.hibernate.type.descriptor.java.BooleanJavaType;

@NoArgsConstructor
public class BookBuilder {

    private final BookDAO bookDAO = new BookDAO();

    public BookBuilder buildMockObject(){
        this.bookDAO.setTitle("Java Programming Language");
        this.bookDAO.setAuthor("James Gosling");
        this.bookDAO.setPrice(25D);
        this.bookDAO.setStockQuantity(10L);
        return this;
    }

    public BookBuilder withTitle(String title){
        this.bookDAO.setTitle(title);
        return this;
    }

    public BookBuilder withAuthor(String author){
        this.bookDAO.setAuthor(author);
        return this;
    }

    public BookBuilder withPrice(Double price){
        this.bookDAO.setPrice(price);
        return this;
    }

    public BookBuilder withStockQuantity(Long stockQuantity){
        this.bookDAO.setStockQuantity(stockQuantity);
        return this;
    }

    public BookDAO build(){
        return this.bookDAO;
    }
}
