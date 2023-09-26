package com.example.onlinebookstore.repository;

import com.example.onlinebookstore.model.OrderItem;
import java.util.Optional;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    Set<OrderItem> findOrderItemsByOrderId(Long id);

    @Query("FROM OrderItem o WHERE o.order.id = :orderId AND o.id = :orderItemId")
    Optional<OrderItem> findOrderItemByOrderIdAndOrderItemId(Long orderId, Long orderItemId);
}
