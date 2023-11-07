package com.mehmetfaruk.bookstore.order.model;

import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public OrderDAO toDAO(Order order){
        if (order == null) {
            return null;
        }

        OrderDAO orderDAO = new OrderDAO();
        orderDAO.setId(order.getId());
        orderDAO.setUserId(order.getUserId());
        orderDAO.setBooks(order.getBooks());
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
        order.setBooks(orderDAO.getBooks());
        order.setOrderDate(orderDAO.getOrderDate());
        order.setTotalPrice(orderDAO.getTotalPrice());

        return order;
    }
}
