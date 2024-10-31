package com.hotelManagementSystem.hotel.service;
import com.hotelManagementSystem.hotel.model.Booking;
import com.hotelManagementSystem.hotel.model.Customer;
import com.hotelManagementSystem.hotel.util.generics.dto.booking.BookingSaveDto;
import com.hotelManagementSystem.hotel.util.generics.service.CommonService;
import net.sf.jasperreports.engine.JRException;

import java.time.LocalDate;
import java.util.List;

public interface BookingService extends CommonService<Booking, Integer> {
    List<Booking> findAll();

    Booking findDetailsById(Integer id);

    Booking update(Booking t, Integer id);

    Booking deleteById(Integer id);


    Booking saveBookingDetails(BookingSaveDto bookingSaveDto);

    Booking changeInOutDate(LocalDate inDate, LocalDate outDate, int bookingId);

    Booking extendOutdate(LocalDate outDate, int bookingId);

    Booking cancelBooking(Integer id);

    byte[] generatePdf() throws JRException;
}
