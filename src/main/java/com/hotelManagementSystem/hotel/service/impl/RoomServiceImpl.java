package com.hotelManagementSystem.hotel.service.impl;

import com.hotelManagementSystem.hotel.exception.NotFoundException;
import com.hotelManagementSystem.hotel.model.Room;
import com.hotelManagementSystem.hotel.model.enums.RoomCategory;
import com.hotelManagementSystem.hotel.model.enums.RoomType;
import com.hotelManagementSystem.hotel.service.RoomService;
import com.hotelManagementSystem.hotel.util.generics.dto.room.AvailableRoomDetails;
import com.hotelManagementSystem.hotel.util.generics.dto.room.RoomSaveDto;
import com.hotelManagementSystem.hotel.util.generics.dto.room.RoomUpdateDto;
import com.hotelManagementSystem.hotel.util.generics.repository.RoomRepository;
import com.hotelManagementSystem.hotel.util.generics.service.impl.CommonServiceImpl;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class RoomServiceImpl extends CommonServiceImpl<Room, Integer, RoomRepository> implements RoomService {
    private static final Logger log = LoggerFactory.getLogger(RoomServiceImpl.class);
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

    @Transactional
    @Override
    public String updateAvailability(int id, boolean available) {
        Room room = repository.findById(id).orElseThrow(() -> new NotFoundException("Cannot Change Availability"));
        room.setRoomAvailable(available);
        repository.saveAndFlush(room);
        return "Availability Is Changed  Successful";
    }

    @Override
    public String updateRoomDetails(RoomUpdateDto updateDto, int id) {
        Room room = repository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Room Details"));
        if (room != null) {
            room.setRoomAvailable(updateDto.isRoomAvailable());
            room.setRoomCategory(updateDto.getRoomCategory());
            room.setRoomType(updateDto.getRoomType());
            room.setRoomPrice(updateDto.getRoomPrice());
            repository.save(room);
            return "Update Successful!";
        } else {
            return "Failed Update";
        }
    }

    @Override
    public List<RoomType> getRoomType() {
        return List.of(RoomType.values());
    }

    @Override
    public List<RoomCategory> getRoomCategory() {
        return List.of(RoomCategory.values());
    }

    @Override
    public List<AvailableRoomDetails> getAvailableRoomDetails(boolean status) {
        log.info("Status:{}", status);
        return repository.findAllByRoomAvailableAAndBeforeService(status,true).stream().map(r -> new AvailableRoomDetails(
                r.getRoomId(),
                r.getRoomPrice(),
                r.getRoomType(),
                r.getRoomCategory(),
                r.isRoomAvailable(),
                r.getBooking()
        )).toList();
    }

}
