package com.hotelManagementSystem.hotel.controller.impl;

import com.hotelManagementSystem.hotel.controller.RoomController;
import com.hotelManagementSystem.hotel.model.Room;
import com.hotelManagementSystem.hotel.service.RoomService;
import com.hotelManagementSystem.hotel.util.generics.controller.impl.CommonControllerImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/room")
@RestController
@CrossOrigin
public class RoomControllerImpl extends CommonControllerImpl<Room,Integer, RoomService> implements RoomController {
}
