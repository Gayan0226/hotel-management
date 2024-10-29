package com.hotelManagementSystem.hotel.service.impl;

import com.hotelManagementSystem.hotel.model.Room;
import com.hotelManagementSystem.hotel.service.RoomService;
import com.hotelManagementSystem.hotel.util.generics.repository.RoomRepository;
import com.hotelManagementSystem.hotel.util.generics.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoomServiceImpl  extends CommonServiceImpl<Room,Integer, RoomRepository> implements RoomService {


    public RoomServiceImpl(RoomRepository repository) {
        super(repository);
    }

    @Override
    public List<Room> findAll() {
        return List.of();
    }

    @Override
    public String findDetailsById(Integer integer) {
        return "";
    }

    @Override
    public Room update(Room room, Integer integer) {
        return null;
    }

    @Override
    public Room deleteById(Integer integer) {
        return null;
    }

    @Override
    public Room create(Room room) {
        return null;
    }
}
