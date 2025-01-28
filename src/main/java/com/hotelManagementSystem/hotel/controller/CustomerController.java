package com.hotelManagementSystem.hotel.controller;

import com.hotelManagementSystem.hotel.model.Customer;
import com.hotelManagementSystem.hotel.util.generics.controller.CommonController;
import com.hotelManagementSystem.hotel.util.generics.dto.UserNamePasswordUpdateDto;
import com.hotelManagementSystem.hotel.util.generics.dto.customer.CustomerSaveDto;
import com.hotelManagementSystem.hotel.util.generics.dto.customer.UpdateProfile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CustomerController extends CommonController<Customer, Integer> {
    @GetMapping("/getAll")
    ResponseEntity<List<Customer>> getAll() throws Exception;

    @GetMapping("/findById/{id}")
    ResponseEntity<Customer> findById(@PathVariable("id") Integer id) throws Exception;

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Customer> delete(@PathVariable("id") Integer id) throws Exception;

    @PatchMapping("/updateProfile/{id}")
    ResponseEntity<String> updateProfileDetails(
            @PathVariable("id") int id,
            @RequestBody UpdateProfile updateProfile
    ) throws Exception;

    @PatchMapping("/changeUserNamePassword/{id}")
    ResponseEntity<String> changeUserNamePassword(
            @PathVariable("id") int id,
            @RequestBody UserNamePasswordUpdateDto updateDto
    ) throws Exception;

    @PostMapping("/saveCustomer")
    ResponseEntity<String> saveCustomer(@RequestBody CustomerSaveDto customerDto) throws Exception;

}
