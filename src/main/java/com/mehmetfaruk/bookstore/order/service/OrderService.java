package com.mehmetfaruk.bookstore.order.service;

import com.mehmetfaruk.bookstore.order.repo.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
}
