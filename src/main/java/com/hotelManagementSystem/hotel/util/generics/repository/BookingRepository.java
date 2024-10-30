package com.hotelManagementSystem.hotel.util.generics.repository;

import com.hotelManagementSystem.hotel.model.Booking;
import com.hotelManagementSystem.hotel.model.Room;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends CommonRepository<Booking,Integer> {
    @Modifying
    @Transactional // Necessary for modifying queries
    @Query(value = "DELETE FROM booking WHERE booking_id = ?1", nativeQuery = true)
    void deleteByIdNative(Integer id);

}
