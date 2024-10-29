package com.hotelManagementSystem.hotel.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerId")
    private int customerId;
    @Column(name = "customerName")
    private int customerName;
    @Column(name = "password")
    private int password;
    @Column(name = "userName")
    private int userName;
    @Column(name = "contactNumber")
    private int contactNumber;
    @Column(name = "customerIdNumber")
    private int idNumber;
    @JsonManagedReference
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Booking> booking;


}
