package com.abcrestaurant.reservation_system.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
    @Id
    private String id;
    private String name;
    private String email;
    private String role; // e.g., admin, staff, customer

    // Constructors, getters, and setters
}




