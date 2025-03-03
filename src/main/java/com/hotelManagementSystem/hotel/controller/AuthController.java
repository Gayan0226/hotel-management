package com.hotelManagementSystem.hotel.controller;

import com.hotelManagementSystem.hotel.util.generics.dto.auth.LoginDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthController {
    ResponseEntity<String> generateToken(@RequestBody LoginDto auth) throws Exception;
}
