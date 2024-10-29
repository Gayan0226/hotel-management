package com.hotelManagementSystem.hotel.service;
import com.hotelManagementSystem.hotel.model.Room;
import com.hotelManagementSystem.hotel.util.generics.dto.RoomSaveDto;
import com.hotelManagementSystem.hotel.util.generics.service.CommonService;

import java.util.List;

public interface RoomService extends CommonService<Room, Integer> {
    List<Room> findAll();

    String findDetailsById(Integer id);

    Room update(Room t, Integer id);

    Room deleteById(Integer id);

    Room create(Room t);

    String save(RoomSaveDto t);
}
