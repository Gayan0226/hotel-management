package com.hotelManagementSystem.hotel.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hotelManagementSystem.hotel.model.enums.RoomCategory;
import com.hotelManagementSystem.hotel.model.enums.RoomType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roomId")
    private int roomId;
    @Column(name = "roomPrice")
    private Long roomPrice;
    @Enumerated(EnumType.STRING)
    @Column(name = "roomType")
    private RoomType roomType;
    @Enumerated(EnumType.STRING)
    @Column(name = "roomCategory")
    private RoomCategory roomCategory;
    @Column(name = "roomAvailable", columnDefinition = "TINYINT(1) default 1")
    private boolean roomAvailable;
    @JsonBackReference(value = "roomBooking")
    @JsonIgnore
    @OneToOne(mappedBy = "room", cascade = CascadeType.ALL)
    private Booking booking;

    public Room(Long roomPrice, RoomType roomType, RoomCategory roomCategory, boolean roomAvailable) {
        this.roomPrice = roomPrice;
        this.roomType = roomType;
        this.roomCategory = roomCategory;
        this.roomAvailable = roomAvailable;
    }
}
