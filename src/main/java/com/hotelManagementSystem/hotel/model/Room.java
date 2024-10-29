package com.hotelManagementSystem.hotel.model;

import jakarta.persistence.*;

@Entity
@Table(name="room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roomId")
    private Integer roomId;
}
