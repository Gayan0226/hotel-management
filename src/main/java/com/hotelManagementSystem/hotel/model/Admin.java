package com.hotelManagementSystem.hotel.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "admin")
@Data
@NoArgsConstructor
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String role = "ADMIN"; // Fixed role

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
