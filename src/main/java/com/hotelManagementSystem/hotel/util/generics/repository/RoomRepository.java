package com.hotelManagementSystem.hotel.util.generics.repository;

import com.hotelManagementSystem.hotel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository<T,ID> extends CommonRepository<T,ID> {
}
