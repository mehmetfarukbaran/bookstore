package com.mehmetfaruk.bookstore.order.service;

import com.mehmetfaruk.bookstore.order.model.OrderDAO;
import com.mehmetfaruk.bookstore.order.repo.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderDAO newOrder(OrderDAO orderDAO){
        return null;
    }

    public List<OrderDAO> getOrdersByUserId(Long userId){
        return null;
    }

    public OrderDAO getOrderDetails(Long id){
        return null;
    }
    //- `POST /orders`: Place a new order for a user with a minimum price of 25$.
    //- `GET /orders/{userId}`: Get all orders for a specific user ordered by update date DESC.
    //- `GET /orders/details/{orderId}`: Get details of a specific order by its ID with the books under that order.
}
