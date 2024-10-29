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
    private String customerName;
    @Column(name = "password")
    private String password;
    @Column(name = "userName")
    private String userName;
    @Column(name = "contactNumber")
    private String contactNumber;
    @Column(name = "customerIdNumber")
    private Long idNumber;
    @JsonManagedReference
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Booking> booking;


}
