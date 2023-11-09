package com.mehmetfaruk.bookstore.order.service;

import com.mehmetfaruk.bookstore.book.model.BookDAO;
import com.mehmetfaruk.bookstore.order.model.OrderDAO;
import com.mehmetfaruk.bookstore.order.model.OrderMapper;
import com.mehmetfaruk.bookstore.order.repo.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderDAO newOrder(OrderDAO orderDAO) throws Exception {
        double totalPrice = 0;
        for (BookDAO book : orderDAO.getBooks()){
            if (book.getStockQuantity() < 1){
                throw new Exception("Dont have enough stock.");
            }
            totalPrice += book.getPrice();
        }
        if (totalPrice < 25){
            throw new Exception("Price must be at least 25.");
        }
        orderDAO.setOrderDate(new Date());
        return orderMapper.toDAO(orderRepository.save(orderMapper.toEntity(orderDAO)));
    }

    public List<OrderDAO> getOrdersByUserId(Long userId){
        return orderRepository.findByUserId(userId).stream().map(orderMapper::toDAO).toList();
    }

    public OrderDAO getOrderDetails(Long id){
        return orderRepository.findById(id).map(orderMapper::toDAO).orElse(null);
    }

}
