package com.mehmetfaruk.bookstore.order.service;

import com.mehmetfaruk.bookstore.order.model.OrderDAO;
import com.mehmetfaruk.bookstore.order.model.OrderMapper;
import com.mehmetfaruk.bookstore.order.repo.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderDAO newOrder(OrderDAO orderDAO){
        return orderMapper.toDAO(orderRepository.save(orderMapper.toEntity(orderDAO)));
    }

    public List<OrderDAO> getOrdersByUserId(Long userId){
        return orderRepository.findByUserId(userId).stream().map(orderMapper::toDAO).toList();
    }

    public OrderDAO getOrderDetails(Long id){
        return orderRepository.findById(id).map(orderMapper::toDAO).orElse(null);
    }

}
