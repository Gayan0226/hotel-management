package com.hotelManagementSystem.hotel.service.impl;

import com.hotelManagementSystem.hotel.model.Admin;
import com.hotelManagementSystem.hotel.service.AdminService;
import com.hotelManagementSystem.hotel.util.generics.repository.AdminRepository;
import com.hotelManagementSystem.hotel.util.generics.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl extends CommonServiceImpl<Admin, Integer, AdminRepository> implements AdminService {
    public AdminServiceImpl(AdminRepository repository) {
        super(repository);
    }
}
