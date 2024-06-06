package com.example.MenuStream.repository;

import com.example.MenuStream.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    // Consultas para busca de pagamentos por status ou método
}
