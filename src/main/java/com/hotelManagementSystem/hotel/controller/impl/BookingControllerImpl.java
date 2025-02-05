package com.hotelManagementSystem.hotel.controller.impl;

import com.hotelManagementSystem.hotel.controller.BookingController;
import com.hotelManagementSystem.hotel.model.Booking;
import com.hotelManagementSystem.hotel.service.BookingService;
import com.hotelManagementSystem.hotel.util.generics.controller.impl.CommonControllerImpl;
import com.hotelManagementSystem.hotel.util.generics.dto.booking.BookingSaveDto;
import com.hotelManagementSystem.hotel.util.generics.repository.BookingRepository;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("/booking")
@CrossOrigin
@RestController
public class BookingControllerImpl extends CommonControllerImpl<Booking, Integer, BookingService> implements BookingController {


    @Override
    public ResponseEntity<List<Booking>> getAll() throws Exception {
        return super.getAll();
    }

    @Override
    public ResponseEntity<Booking> findById(Integer integer) throws Exception {
        return super.findById(integer);
    }

    @Override
    public ResponseEntity<Booking> cancelBooking(Integer id) throws Exception {
        return new ResponseEntity<Booking>(service.cancelBooking(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Booking> update(Booking booking, Integer integer) throws Exception {
        return super.update(booking, integer);
    }


    @Override
    public ResponseEntity<Booking> addBooking(BookingSaveDto bookingSaveDto) throws Exception {
        return new ResponseEntity<Booking>(service.saveBookingDetails(bookingSaveDto), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Booking> changeInAndOutDate(int bookingId, LocalDate inDate, LocalDate outDate) throws Exception {
        return new ResponseEntity<Booking>(service.changeInOutDate(inDate, outDate, bookingId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Booking> extendOutDate(int bookingId, LocalDate outDate) throws Exception {
        return new ResponseEntity<Booking>(service.extendOutdate(outDate, bookingId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<byte[]> getDetailsAsPdf() throws Exception {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_PDF);
        httpHeaders.setContentDisposition(ContentDisposition.inline().filename("Report.pdf").build());
        return  new ResponseEntity<byte[]>(service.generatePdf(),httpHeaders,HttpStatus.OK) ;
    }

    public BookingControllerImpl(BookingService service) {
        super(service);
    }
}
