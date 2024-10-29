package com.hotelManagementSystem.hotel.controller;

import com.hotelManagementSystem.hotel.model.Booking;
import com.hotelManagementSystem.hotel.model.Room;
import com.hotelManagementSystem.hotel.util.generics.controller.CommonController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

public interface BookingController extends CommonController<Booking,Integer> {
    @GetMapping("/getAll")
    ResponseEntity<List<Booking>> getAll() throws Exception;

    @GetMapping("/findById/{id}")
    ResponseEntity<Booking> findById(@PathVariable("id") Integer id) throws Exception;

    @PutMapping("/updateAllData")
    ResponseEntity<Booking> update(Booking t, Integer id) throws Exception;

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Booking> delete(@PathVariable("id") Integer id) throws Exception;

}
