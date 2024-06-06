package com.example.MenuStream.repository;
import com.example.MenuStream.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    // Métodos adicionais para gerenciar o carrinho de compras
}
