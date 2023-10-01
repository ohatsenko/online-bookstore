package com.example.onlinebookstore.service;

import com.example.onlinebookstore.dto.CreateOrderRequestDto;
import com.example.onlinebookstore.dto.OrderDto;
import com.example.onlinebookstore.dto.OrderItemDto;
import com.example.onlinebookstore.dto.UpdateStatusOrderDto;
import java.util.Set;
import org.springframework.data.domain.Pageable;

public interface OrderService {
    void createOrder(CreateOrderRequestDto orderRequestDto);

    Set<OrderDto> getOrders(Pageable pageable);

    OrderItemDto getOrderItemById(Long orderId, Long itemId);

    Set<OrderItemDto> getAllOrderItemsByOrderId(Long orderId);

    void updateOrderStatus(Long id, UpdateStatusOrderDto status);
}
