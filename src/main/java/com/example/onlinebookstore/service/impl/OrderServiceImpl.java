package com.example.onlinebookstore.service.impl;

import com.example.onlinebookstore.dto.CreateOrderRequestDto;
import com.example.onlinebookstore.dto.OrderDto;
import com.example.onlinebookstore.dto.OrderItemDto;
import com.example.onlinebookstore.dto.UpdateStatusOrderDto;
import com.example.onlinebookstore.exception.EntityNotFoundException;
import com.example.onlinebookstore.mapper.OrderItemMapper;
import com.example.onlinebookstore.mapper.OrderMapper;
import com.example.onlinebookstore.model.CartItem;
import com.example.onlinebookstore.model.Order;
import com.example.onlinebookstore.model.OrderItem;
import com.example.onlinebookstore.repository.CartItemRepository;
import com.example.onlinebookstore.repository.OrderItemRepository;
import com.example.onlinebookstore.repository.OrderRepository;
import com.example.onlinebookstore.service.OrderService;
import com.example.onlinebookstore.service.ShoppingCartService;
import com.example.onlinebookstore.service.UserService;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final UserService userService;
    private final CartItemRepository cartItemRepository;
    private final ShoppingCartService shoppingCartService;
    private final OrderMapper orderMapper;
    private final OrderItemRepository orderItemRepository;
    private final OrderItemMapper orderItemMapper;

    @Override
    public void createOrder(CreateOrderRequestDto orderRequestDto) {
        Order order = new Order();
        order.setUser(userService.getAuthenticatedUser());
        order.setStatus(Order.Status.PENDING);
        order.setOrderDate(LocalDateTime.now());
        order.setShippingAddress(orderRequestDto.getShippingAddress());
        Set<OrderItem> orderItems = cartItemRepository
                .findCartItemsByShoppingCartId(shoppingCartService
                        .getShoppingCart(order.getUser().getId())
                        .getId())
                .stream()
                .map(e -> createOrderItem(e, order))
                .collect(Collectors.toSet());
        order.setOrderItems(orderItems);
        order.setTotal(order.getOrderItems().stream()
                .map(e -> e.getBook().getPrice())
                .reduce(BigDecimal.ZERO, BigDecimal::add));
        orderRepository.save(order);
    }

    @Override
    public Set<OrderDto> getOrders() {
        return orderRepository.findAllOrdersByUserId(userService.getAuthenticatedUser()
                        .getId()).stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<OrderItemDto> getOrderItemsByOrderId(Long id) {
        return orderItemRepository.findOrderItemsByOrderId(id).stream()
                .map(orderItemMapper::toDto)
                .collect(Collectors.toSet());
    }

    @Override
    public OrderItemDto getOrderItemByOrderIdAndOrderItemId(Long orderId, Long orderItemId) {
        return orderItemRepository.findOrderItemByOrderIdAndOrderItemId(orderId, orderItemId)
                .map(orderItemMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Order item by provided id: "
                        + orderItemId + " doesn't exists"));
    }

    @Override
    public void updateOrderStatus(Long id, UpdateStatusOrderDto status) {
        Order order = getOrderById(id);
        order.setStatus(status.getStatus());
        orderRepository.save(order);
    }

    private OrderItem createOrderItem(CartItem cartItem, Order order) {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order);
        orderItem.setBook(cartItem.getBook());
        orderItem.setQuantity(cartItem.getQuantity());
        orderItem.setPrice(cartItem.getBook().getPrice());
        return orderItem;
    }

    private Order getOrderById(Long id) {
        return orderRepository.getOrderById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order by provided id "
                        + id + " doesn't exists"));
    }
}
