package com.hotelManagementSystem.hotel.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
    @JsonIgnore
    private String password;
    @JsonIgnore
    @Column(name = "userName")
    private String userName;
    @Column(name = "contactNumber")
    private String contactNumber;
    @Column(name = "customerIdNumber")
    private Long idNumber;
    @JsonManagedReference(value="customer")
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<Booking> booking;

    public Customer(String customerName, String password, String userName, String contactNumber, Long idNumber) {
        this.customerName = customerName;
        this.password = password;
        this.userName = userName;
        this.contactNumber = contactNumber;
        this.idNumber = idNumber;
    }
}
