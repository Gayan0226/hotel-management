package com.hotelManagementSystem.hotel.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookingId")
    private int bookingId;
    @Column(name = "outDate")
    private LocalDate outDate;
    @Column(name = "inDate")
    private LocalDate inDate;
    @JsonBackReference(value = "roomBooking")
    @OneToOne
    @JoinColumn(name = "roomId")
    private Room room;
    @JsonBackReference(value="customer")
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;
    @Column(name = "createTime")
    private LocalDateTime createTime;
    @Column(name = "updateTime")
    private LocalDateTime updateTime;
    @PrePersist
    protected void onCreateTime() {
        if (createTime == null) {
            createTime = LocalDateTime.now();
        }
    }

    @PreUpdate
    protected void onUpdateTime() {
        if (updateTime == null || updateTime.isBefore(LocalDateTime.now())) {
            updateTime = LocalDateTime.now();
        }
    }
    public Booking(LocalDate outDate, LocalDate inDate, Room room, Customer customer) {
        this.outDate = outDate;
        this.inDate = inDate;
        this.room = room;
        this.customer = customer;
    }

}
