package com.example.onlinebookstore.controller;

import com.example.onlinebookstore.dto.CreateOrderRequestDto;
import com.example.onlinebookstore.dto.OrderDto;
import com.example.onlinebookstore.dto.OrderItemDto;
import com.example.onlinebookstore.dto.UpdateStatusOrderDto;
import com.example.onlinebookstore.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Order management", description = "Endpoints for managing orders")
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/orders")
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    @Operation(summary = "Get an order history", description
            = "Get an order history")
    public Set<OrderDto> getOrder(Pageable pageable) {
        return orderService.getOrders(pageable);
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Operation(summary = "Create a new order", description
            = "Create a new order")
    public void createOrder(@RequestBody @Valid CreateOrderRequestDto orderRequestDto) {
        orderService.createOrder(orderRequestDto);
    }

    @GetMapping("{orderId}/items")
    @PreAuthorize("hasRole('ROLE_USER')")
    @Operation(summary = "Get an order items", description
            = "Get an order items")
    public Set<OrderItemDto> getOrderItemsByOrderId(@PathVariable Long orderId) {
        return orderService.getAllOrderItemsByOrderId(orderId);
    }

    @GetMapping("{orderId}/items/{itemId}")
    @PreAuthorize("hasRole('ROLE_USER')")
    @Operation(summary = "Get an order's item", description
            = "Get an order's item")
    public OrderItemDto getOrderSpecificItem(@PathVariable Long orderId, @PathVariable
            Long itemId) {
        return orderService.getOrderItemById(orderId, itemId);
    }

    @PatchMapping("{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Operation(summary = "Update order status", description
            = "Update order status. Admin only")
    public void updateOrderStatus(@PathVariable Long id,
                                  @RequestBody UpdateStatusOrderDto orderStatusRequestDto) {
        orderService.updateOrderStatus(id, orderStatusRequestDto);
    }
}
