package com.hotelManagementSystem.hotel.controller.impl;

import com.hotelManagementSystem.hotel.controller.AdminController;
import com.hotelManagementSystem.hotel.model.Admin;
import com.hotelManagementSystem.hotel.service.AdminService;
import com.hotelManagementSystem.hotel.util.generics.controller.impl.CommonControllerImpl;
import com.hotelManagementSystem.hotel.util.generics.dto.AdminRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminControllerImpl extends CommonControllerImpl<Admin, Integer, AdminService> implements AdminController {
    public AdminControllerImpl(AdminService service) {
        super(service);
    }

    @Override
    public ResponseEntity<List<Admin>> getAll() throws Exception {
        return super.getAll();
    }

    @Override
    public ResponseEntity<Admin> findById(Integer integer) throws Exception {
        return super.findById(integer);
    }

    @Override
    public ResponseEntity<Admin> update(Admin admin, Integer integer) throws Exception {
        return super.update(admin, integer);
    }

    @Override
    public ResponseEntity<Admin> delete(Integer integer) throws Exception {
        return super.delete(integer);
    }

    @Override
    public ResponseEntity<String> createAdmin(AdminRequestDto admin) throws Exception {
        return new ResponseEntity<String>(service.createAdmin(admin), HttpStatus.CREATED);
    }
}
