package com.mehmetfaruk.bookstore.book.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Data
public class BookDAO {
    private Long isbn;
    private String title;
    private String author;
    private Double price;
    private Long stockQuantity;
}
