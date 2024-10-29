package com.hotelManagementSystem.hotel.util.generics.mapper;

import com.hotelManagementSystem.hotel.model.Room;
import com.hotelManagementSystem.hotel.util.generics.dto.RoomSaveDto;
import org.mapstruct.Mapper;

//@Mapper(componentModel = "spring")
public interface RoomMap {
 Room  dtoToEntity(RoomSaveDto dto);
}
