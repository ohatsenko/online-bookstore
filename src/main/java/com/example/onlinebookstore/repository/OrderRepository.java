package com.example.onlinebookstore.repository;

import com.example.onlinebookstore.model.Order;
import java.util.Optional;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Set<Order> findAllOrdersByUserId(Long id);

    Optional<Order> getOrderById(Long id);
}
