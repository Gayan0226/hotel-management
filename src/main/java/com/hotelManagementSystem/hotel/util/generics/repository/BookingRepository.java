package com.hotelManagementSystem.hotel.util.generics.repository;

import com.hotelManagementSystem.hotel.model.Booking;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends CommonRepository<Booking, Integer> {
    @Modifying
    @Transactional // Necessary for modifying queries
    @Query(value = "DELETE FROM booking WHERE booking_id = ?1", nativeQuery = true)
    void deleteByIdNative(Integer id);

    @Query(value = "SELECT * FROM booking WHERE out_date <= ?1", nativeQuery = true)
    List<Booking> checkExpiredDate(LocalDate checkDate);
@Query(value = "update booking b SET b.active=?1 WHERE b.booking_id=?2",nativeQuery = true)
    void changeActiveStatusByBookingId(boolean b, int bookingId);
}
