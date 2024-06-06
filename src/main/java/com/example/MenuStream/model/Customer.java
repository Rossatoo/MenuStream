package com.example.MenuStream.model;

import com.example.MenuStream.DTO.CustomerDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email; // Assuming email as the contact detail

    @Column(nullable = false)
    private String deliveryAddress;

    @Column(nullable = true)
    private String paymentPreferences;
    // Constructors, getters and setters

    public Customer (CustomerDTO data){
        this.name = data.name();
        this.email = data.email();
        this.deliveryAddress = data.deliveryAddress();
        this.paymentPreferences = data.paymentPreferences();
    }
}
