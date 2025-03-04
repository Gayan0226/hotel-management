package com.hotelManagementSystem.hotel.controller.impl;

import com.hotelManagementSystem.hotel.controller.AuthController;
import com.hotelManagementSystem.hotel.service.impl.CommonUserDetailService;
import com.hotelManagementSystem.hotel.util.generics.dto.auth.LoginDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthControllerImpl implements AuthController {
    private final CommonUserDetailService service;

    public AuthControllerImpl(CommonUserDetailService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<String> generateToken(LoginDto auth) throws Exception {
        return new ResponseEntity<String>(service.isValidUser(auth), HttpStatus.OK);
    }
}
