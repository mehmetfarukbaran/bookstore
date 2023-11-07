package com.mehmetfaruk.bookstore.order.model;

import com.mehmetfaruk.bookstore.book.model.BookMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OrderMapper {

    private final BookMapper bookMapper;
    public OrderDAO toDAO(Order order){
        if (order == null) {
            return null;
        }

        OrderDAO orderDAO = new OrderDAO();
        orderDAO.setId(order.getId());
        orderDAO.setUserId(order.getUserId());
        orderDAO.setBooks(order.getBooks().stream().map(bookMapper::toDAO).toList());
        orderDAO.setOrderDate(order.getOrderDate());
        orderDAO.setTotalPrice(order.getTotalPrice());

        return orderDAO;
    }

    public Order toEntity(OrderDAO orderDAO){
        if (orderDAO == null) {
            return null;
        }

        Order order = new Order();
        order.setId(orderDAO.getId());
        order.setUserId(orderDAO.getUserId());
        order.setBooks(orderDAO.getBooks().stream().map(bookMapper::toEntity).toList());
        order.setOrderDate(orderDAO.getOrderDate());
        order.setTotalPrice(orderDAO.getTotalPrice());

        return order;
    }
}
