package com.hotelManagementSystem.hotel.util.generics.repository;

import com.hotelManagementSystem.hotel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends CommonRepository<Room,Integer> {

@Query(value = "SELECT *FROM room r WHERE r.room_available=?1 AND r.is_before_service=?2",nativeQuery = true)
    List<Room> findAllByRoomAvailableAAndBeforeService(boolean status,boolean service);
}
