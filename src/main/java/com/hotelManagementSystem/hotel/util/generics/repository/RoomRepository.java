package com.hotelManagementSystem.hotel.util.generics.repository;

import com.hotelManagementSystem.hotel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends CommonRepository<Room,Integer> {

    List<Room> findAllByRoomAvailable(boolean status);
}
