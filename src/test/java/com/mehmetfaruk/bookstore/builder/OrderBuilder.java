package com.mehmetfaruk.bookstore.builder;

import com.mehmetfaruk.bookstore.book.model.BookDAO;
import com.mehmetfaruk.bookstore.order.model.OrderDAO;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
public class OrderBuilder {

    private final OrderDAO orderDAO = new OrderDAO();

    public OrderBuilder buildMockObject(){
        this.orderDAO.setOrderDate(new Date());
        return this;
    }

    public OrderBuilder withUserId(Long userId){
        this.orderDAO.setUserId(userId);
        return this;
    }

    public OrderBuilder withBooks(List<BookDAO> books){
        this.orderDAO.setBooks(books);
        return this;
    }

    public OrderBuilder withTotalPrice(Double totalPrice){
        this.orderDAO.setTotalPrice(totalPrice);
        return this;
    }

    public OrderDAO build(){
        return this.orderDAO;
    }

}
