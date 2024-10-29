package com.hotelManagementSystem.hotel.controller.impl;

import com.hotelManagementSystem.hotel.controller.RoomController;
import com.hotelManagementSystem.hotel.model.Room;
import com.hotelManagementSystem.hotel.service.RoomService;
import com.hotelManagementSystem.hotel.util.generics.controller.impl.CommonControllerImpl;
import com.hotelManagementSystem.hotel.util.generics.dto.RoomSaveDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/room")
@RestController
@CrossOrigin
public class RoomControllerImpl extends CommonControllerImpl<Room,Integer, RoomService> implements RoomController {

    public RoomControllerImpl(RoomService service) {
        super(service);
    }

    @Override
    public ResponseEntity<String> add(RoomSaveDto t) throws Exception {
        return new ResponseEntity<String>(service.save(t), HttpStatus.OK);
    }
}
