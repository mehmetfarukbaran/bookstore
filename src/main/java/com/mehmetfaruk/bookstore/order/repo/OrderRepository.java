package com.mehmetfaruk.bookstore.order.repo;

import com.mehmetfaruk.bookstore.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

    List<Order> findByUserIdOrderByUpdatedDateDesc(Long userId);
}
