package com.hotelManagementSystem.hotel.util.generics.mapper;

import com.hotelManagementSystem.hotel.model.Room;
import com.hotelManagementSystem.hotel.util.generics.dto.room.RoomSaveDto;

//@Mapper(componentModel = "spring")
public interface RoomMap {
 Room  dtoToEntity(RoomSaveDto dto);
}
