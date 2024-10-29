package com.hotelManagementSystem.hotel.controller;

import com.hotelManagementSystem.hotel.model.Room;
import com.hotelManagementSystem.hotel.util.generics.controller.CommonController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface RoomController extends CommonController<Room, Integer> {
    @GetMapping("/getAll")
    ResponseEntity<List<Room>> getAll() throws Exception;

    @GetMapping("/findById/{id}")
    ResponseEntity<String> findById(@PathVariable("id") Integer id) throws Exception;

    @PutMapping("/updateAllData")
    ResponseEntity<Room> update(Room t, Integer id) throws Exception;

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Room> delete(@PathVariable("id") Integer id) throws Exception;

    @PostMapping("/save")
    ResponseEntity<Room> add(@RequestBody Room t) throws Exception;
}
