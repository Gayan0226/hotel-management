package com.hotelManagementSystem.hotel.util.generics.dto.room;

import com.hotelManagementSystem.hotel.model.enums.RoomCategory;
import com.hotelManagementSystem.hotel.model.enums.RoomType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoomUpdateDto {
    private Long roomPrice;
    private RoomType roomType;
    private RoomCategory roomCategory;
    private boolean roomAvailable;

}
