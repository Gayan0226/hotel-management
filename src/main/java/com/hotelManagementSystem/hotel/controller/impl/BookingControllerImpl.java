package com.hotelManagementSystem.hotel.controller.impl;

import com.hotelManagementSystem.hotel.controller.BookingController;
import com.hotelManagementSystem.hotel.model.Booking;
import com.hotelManagementSystem.hotel.service.BookingService;
import com.hotelManagementSystem.hotel.util.generics.controller.impl.CommonControllerImpl;
import com.hotelManagementSystem.hotel.util.generics.dto.booking.BookingSaveDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/booking")
@CrossOrigin
@RestController
public class BookingControllerImpl extends CommonControllerImpl<Booking,Integer, BookingService> implements BookingController {
    @Override
    public ResponseEntity<List<Booking>> getAll() throws Exception {
        return super.getAll();
    }

    @Override
    public ResponseEntity<Booking> findById(Integer integer) throws Exception {
        return super.findById(integer);
    }

    @Override
    public ResponseEntity<Booking> update(Booking booking, Integer integer) throws Exception {
        return super.update(booking, integer);
    }

    @Override
    public ResponseEntity<Booking> delete(Integer integer) throws Exception {
        return super.delete(integer);
    }

    @Override
    public ResponseEntity<Booking> addBooking(BookingSaveDto bookingSaveDto) throws Exception {
        return new ResponseEntity<Booking>(service.saveBookingDetails(bookingSaveDto), HttpStatus.OK);
    }

    public BookingControllerImpl(BookingService service) {
        super(service);
    }
}
