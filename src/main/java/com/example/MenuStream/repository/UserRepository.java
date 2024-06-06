package com.example.MenuStream.repository;

import com.example.MenuStream.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Adicionar consultas para buscar usuários por username ou role, se necessário
}
