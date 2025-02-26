package com.hotelManagementSystem.hotel.controller;

import com.hotelManagementSystem.hotel.model.Admin;
import com.hotelManagementSystem.hotel.util.generics.controller.CommonController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

public interface AdminController extends CommonController<Admin, Integer> {
    @GetMapping("/admins")
    ResponseEntity<List<Admin>> getAll() throws Exception;

    @GetMapping("/admin")
    ResponseEntity<Admin> findById(Integer id) throws Exception;

    @PutMapping("/update")
    ResponseEntity<Admin> update(Admin t, Integer id) throws Exception;

    @PostMapping("/create")
    ResponseEntity<Admin> delete(Integer id) throws Exception;
}
