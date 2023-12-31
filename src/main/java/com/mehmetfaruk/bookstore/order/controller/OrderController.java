package com.mehmetfaruk.bookstore.order.controller;

import com.mehmetfaruk.bookstore.order.model.OrderDAO;
import com.mehmetfaruk.bookstore.order.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/orders")
@SecurityRequirement(name = "bookstoreapi")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDAO> newOrder(@Valid @RequestBody OrderDAO orderDAO) throws Exception {
        return ResponseEntity.ok(orderService.newOrder(orderDAO));
    }

    @GetMapping("/{userId}")
    @Operation(description = "To retrieve all orders by user, you must send an exist userId")
    public ResponseEntity<List<OrderDAO>> getAllOrdersByUserId(@NotNull @PathVariable Long userId){
        return ResponseEntity.ok(orderService.getOrdersByUserId(userId));
    }

    @GetMapping("/details/{orderId}")
    @Operation(description = "To retrieve order detail, you must send an exist orderId")
    public ResponseEntity<OrderDAO> getOrderDetails(@NotNull @PathVariable Long orderId){
        return ResponseEntity.ok(orderService.getOrderDetails(orderId));
    }
}
