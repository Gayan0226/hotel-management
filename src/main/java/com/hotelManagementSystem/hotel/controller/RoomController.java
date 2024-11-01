package com.hotelManagementSystem.hotel.controller;

import com.hotelManagementSystem.hotel.model.Room;
import com.hotelManagementSystem.hotel.model.enums.RoomCategory;
import com.hotelManagementSystem.hotel.model.enums.RoomType;
import com.hotelManagementSystem.hotel.util.generics.controller.CommonController;
import com.hotelManagementSystem.hotel.util.generics.dto.room.AvailableRoomDetails;
import com.hotelManagementSystem.hotel.util.generics.dto.room.RoomSaveDto;
import com.hotelManagementSystem.hotel.util.generics.dto.room.RoomUpdateDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public interface RoomController extends CommonController<Room, Integer> {
    @GetMapping("/getAll")
    ResponseEntity<List<Room>> getAll() throws Exception;

    @GetMapping("/findById/{id}")
    ResponseEntity<Room> findById(@PathVariable("id") Integer id) throws Exception;

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Room> delete(@PathVariable("id") Integer id) throws Exception;

    @PostMapping("/save")
    ResponseEntity<String> saveDto(@RequestBody RoomSaveDto t) throws Exception;

    @PatchMapping(path = {"/updateAvailability/{id}"},
            params = {"isAvailable"}
    )
    ResponseEntity<String> updateAvailability(
            @PathVariable("id") int id,
            @RequestParam(value = "isAvailable") boolean available

    ) throws Exception;

    @PatchMapping("/roomDetails/{id}")
    ResponseEntity<String> updateAvailability(
            @PathVariable("id") int id,
            @RequestBody RoomUpdateDto updateDto
    ) throws Exception;

    @GetMapping("/roomType")
    ResponseEntity<List<RoomType>> getRoomType() throws Exception;

    @GetMapping("/roomCategory")
    ResponseEntity<List<RoomCategory>> getRoomCategory() throws Exception;

    @GetMapping("/availableRoomBy/{status}")
    ResponseEntity<List<AvailableRoomDetails>> getRoomAvailable(@PathVariable("status")boolean status) throws Exception;
}
