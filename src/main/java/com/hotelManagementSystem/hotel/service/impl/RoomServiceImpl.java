package com.hotelManagementSystem.hotel.service.impl;

import com.hotelManagementSystem.hotel.model.Room;
import com.hotelManagementSystem.hotel.service.RoomService;
import com.hotelManagementSystem.hotel.util.generics.repository.RoomRepository;
import com.hotelManagementSystem.hotel.util.generics.service.impl.CommonServiceImpl;

public class RoomServiceImpl extends CommonServiceImpl<Room,Integer,RoomRepository<Room,Integer>> implements RoomService {
}
