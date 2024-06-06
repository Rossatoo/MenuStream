package com.example.MenuStream.repository;

import com.example.MenuStream.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // Pode incluir consultas para encontrar pedidos por status ou data
}
