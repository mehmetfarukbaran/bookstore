package com.mehmetfaruk.bookstore.book.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.util.Date;

@Table
@Entity
@Data
public class Book implements Serializable {

    @Id
    @Column
    @GeneratedValue(generator = "book_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "book_gen", sequenceName = "book_seq", initialValue = 1000000)
    private Long isbn;
    private String title;
    private String author;
    @Getter
    private Double price;
    private Long stockQuantity;
    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;

}
