package com.hotelManagementSystem.hotel.controller.impl;

import com.hotelManagementSystem.hotel.controller.RoomController;
import com.hotelManagementSystem.hotel.model.Room;
import com.hotelManagementSystem.hotel.model.enums.RoomCategory;
import com.hotelManagementSystem.hotel.model.enums.RoomType;
import com.hotelManagementSystem.hotel.service.RoomService;
import com.hotelManagementSystem.hotel.util.generics.controller.impl.CommonControllerImpl;
import com.hotelManagementSystem.hotel.util.generics.dto.room.RoomSaveDto;
import com.hotelManagementSystem.hotel.util.generics.dto.room.RoomUpdateDto;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/room")
@CrossOrigin
public class RoomControllerImpl extends CommonControllerImpl<Room, Integer, RoomService> implements RoomController {

    @Override
    public ResponseEntity<Room> delete(Integer integer) throws Exception {
        return super.delete(integer);
    }

    @Override
    public ResponseEntity<List<Room>> getAll() throws Exception {
        return super.getAll();
    }

    public RoomControllerImpl(RoomService service) {
        super(service);
    }

    @Override
    public ResponseEntity<String> saveDto(RoomSaveDto t) throws Exception {
        return new ResponseEntity<String>(service.save(t), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> updateAvailability(int id, boolean available) throws Exception {
        return new ResponseEntity<String>(service.updateAvailability(id, available), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> updateAvailability(int id, RoomUpdateDto updateDto) throws Exception {
        return new ResponseEntity<String>(service.updateRoomDetails(updateDto, id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<RoomType>> getRoomType() throws Exception {
        return new ResponseEntity<List<RoomType>>(service.getRoomType(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<RoomCategory>> getRoomCategory() throws Exception {
        return new ResponseEntity<List<RoomCategory>>(service.getRoomCategory(),HttpStatus.OK);
    }
}
