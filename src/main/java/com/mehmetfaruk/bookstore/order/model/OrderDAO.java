package com.mehmetfaruk.bookstore.order.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderDAO {
    private Long id;
    private Long userId;
    private Double totalPrice;
    private List<String> books;
    private Date orderDate;
}
