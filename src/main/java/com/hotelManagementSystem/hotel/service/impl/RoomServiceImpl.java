package com.hotelManagementSystem.hotel.service.impl;

import com.hotelManagementSystem.hotel.model.Room;
import com.hotelManagementSystem.hotel.service.RoomService;
import com.hotelManagementSystem.hotel.util.generics.dto.RoomSaveDto;
import com.hotelManagementSystem.hotel.util.generics.mapper.RoomMap;
import com.hotelManagementSystem.hotel.util.generics.repository.RoomRepository;
import com.hotelManagementSystem.hotel.util.generics.service.impl.CommonServiceImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl extends CommonServiceImpl<Room, Integer, RoomRepository> implements RoomService {
    @Autowired
    ModelMapper modelMapper;

    public RoomServiceImpl(RoomRepository repository) {
        super(repository);
    }

    @Override
    public String save(RoomSaveDto t) {
        Room map = modelMapper.map(t, Room.class);
        repository.save(map);
        return "Save Successful!";
    }

}
