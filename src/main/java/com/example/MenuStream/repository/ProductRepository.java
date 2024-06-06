package com.example.MenuStream.repository;

import com.example.MenuStream.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Aqui você pode adicionar consultas personalizadas, se necessário
}
