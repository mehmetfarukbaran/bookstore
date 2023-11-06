package com.mehmetfaruk.bookstore.order.model;

import com.mehmetfaruk.bookstore.book.model.Book;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table
@Entity
@Data
public class Order implements Serializable {

    @Id
    @Column
    @GeneratedValue(generator = "user_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "user_gen", sequenceName = "user_seq", initialValue = 1000)
    private Long id;
    private Long userId;
    private Double totalPrice;
    private List<Book> books;
    private Date orderDate;
    private Date createdAt;
    private Date updatedAt;

    //User ID, Total Price, List of Books, Order Date, CreatedAt,
    //UpdatedAt.

}
