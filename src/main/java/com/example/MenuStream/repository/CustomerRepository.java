package com.example.MenuStream.repository;

import com.example.MenuStream.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Métodos de busca específicos podem ser adicionados aqui
}
