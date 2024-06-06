package com.example.MenuStream.repository;

import com.example.MenuStream.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    // Opções para encontrar itens por carrinho ou produto
}

