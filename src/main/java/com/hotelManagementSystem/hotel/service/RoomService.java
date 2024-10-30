package com.hotelManagementSystem.hotel.service;

import com.hotelManagementSystem.hotel.model.Room;
import com.hotelManagementSystem.hotel.model.enums.RoomCategory;
import com.hotelManagementSystem.hotel.model.enums.RoomType;
import com.hotelManagementSystem.hotel.util.generics.dto.room.RoomSaveDto;
import com.hotelManagementSystem.hotel.util.generics.dto.room.RoomUpdateDto;
import com.hotelManagementSystem.hotel.util.generics.service.CommonService;
import org.springframework.http.HttpStatusCode;

import java.util.List;

public interface RoomService extends CommonService<Room, Integer> {
    List<Room> findAll();

    Room findDetailsById(Integer id);

    Room update(Room t, Integer id);

    Room deleteById(Integer id);

    String save(RoomSaveDto t);

    String updateAvailability(int id, boolean available);

    String updateRoomDetails(RoomUpdateDto updateDto, int id);

    List<RoomType> getRoomType();

    List<RoomCategory> getRoomCategory();
}
