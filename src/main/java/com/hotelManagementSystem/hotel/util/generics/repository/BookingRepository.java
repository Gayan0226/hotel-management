package com.hotelManagementSystem.hotel.util.generics.repository;

import com.hotelManagementSystem.hotel.model.Booking;
import com.hotelManagementSystem.hotel.model.Room;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends CommonRepository<Booking,Integer> {
}
