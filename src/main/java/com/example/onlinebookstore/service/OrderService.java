package com.example.onlinebookstore.service;

import com.example.onlinebookstore.dto.CreateOrderRequestDto;
import com.example.onlinebookstore.dto.OrderDto;
import com.example.onlinebookstore.dto.OrderItemDto;
import com.example.onlinebookstore.dto.UpdateStatusOrderDto;
import java.util.Set;

public interface OrderService {
    void createOrder(CreateOrderRequestDto orderRequestDto);

    Set<OrderDto> getOrders();

    Set<OrderItemDto> getOrderItemsByOrderId(Long id);

    OrderItemDto getOrderItemByOrderIdAndOrderItemId(Long orderId, Long orderItemId);

    void updateOrderStatus(Long id, UpdateStatusOrderDto status);
}
