package com.mehmetfaruk.bookstore.order.model;

import com.mehmetfaruk.bookstore.book.model.BookDAO;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderDAO {
    private Long id;
    private Long userId;
    private Double totalPrice;
    private List<BookDAO> books;
    private Date orderDate;
}
