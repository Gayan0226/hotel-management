package com.hotelManagementSystem.hotel.util.generics.dto.room;

import com.hotelManagementSystem.hotel.model.Booking;
import com.hotelManagementSystem.hotel.model.enums.RoomCategory;
import com.hotelManagementSystem.hotel.model.enums.RoomType;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AvailableRoomDetails {
    private int roomId;
    private Long roomPrice;
    private RoomType roomType;
    private RoomCategory roomCategory;
    private boolean roomAvailable;
    private Booking booking;
}
