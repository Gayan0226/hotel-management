package com.hotelManagementSystem.hotel.controller;

import com.hotelManagementSystem.hotel.model.Booking;
import com.hotelManagementSystem.hotel.util.generics.controller.CommonController;
import com.hotelManagementSystem.hotel.util.generics.dto.booking.BookingSaveDto;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

public interface BookingController extends CommonController<Booking, Integer> {
    @GetMapping("/getAll")
    ResponseEntity<List<Booking>> getAll() throws Exception;

    @GetMapping("/findById/{id}")
    ResponseEntity<Booking> findById(@PathVariable("id") Integer id) throws Exception;

    @DeleteMapping("/cancelBooking/{id}")
    ResponseEntity<Booking> cancelBooking(@PathVariable("id") Integer id) throws Exception;

    @PostMapping("/addBooking")
    ResponseEntity<Booking> addBooking(@RequestBody BookingSaveDto bookingSaveDto) throws Exception;

    @PatchMapping(
            path = {"/updateBookingDate/bookingId/{id}"},
            params = {"inDate","outDate"}
    )
    ResponseEntity<Booking> changeInAndOutDate(
            @PathVariable("id") int bookingId,
            @RequestParam(value = "inDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inDate,
            @RequestParam(value = "outDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate outDate
    ) throws Exception;

    @PatchMapping(
            path = {"/extendOutDate/bookingId/{id}"},
            params = {"outDate"}
    )
    ResponseEntity<Booking> extendOutDate(
            @PathVariable("id") int bookingId,
            @RequestParam(value = "outDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate outDate
    ) throws Exception;

}
