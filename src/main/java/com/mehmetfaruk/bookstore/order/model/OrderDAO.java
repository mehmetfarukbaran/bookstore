package com.mehmetfaruk.bookstore.order.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Data
public class OrderDAO {
    private Long id;
    private Long userId;
    private Double totalPrice;
    // TODO: 7.11.2023 bura neden olmuyor bi araştır bakam
    //private List<Book> books;
    private Date orderDate;
    private Date createdAt;
    private Date updatedAt;
}
