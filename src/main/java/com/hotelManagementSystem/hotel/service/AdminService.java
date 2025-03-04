package com.hotelManagementSystem.hotel.service;

import com.hotelManagementSystem.hotel.model.Admin;
import com.hotelManagementSystem.hotel.util.generics.dto.AdminRequestDto;
import com.hotelManagementSystem.hotel.util.generics.service.CommonService;

public interface AdminService extends CommonService<Admin, Integer> {
    String createAdmin(AdminRequestDto admin);
}
