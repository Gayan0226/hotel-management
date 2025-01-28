package com.hotelManagementSystem.hotel.service;
import com.hotelManagementSystem.hotel.model.Customer;
import com.hotelManagementSystem.hotel.model.Room;
import com.hotelManagementSystem.hotel.util.generics.dto.UserNamePasswordUpdateDto;
import com.hotelManagementSystem.hotel.util.generics.dto.customer.CustomerSaveDto;
import com.hotelManagementSystem.hotel.util.generics.dto.customer.UpdateProfile;
import com.hotelManagementSystem.hotel.util.generics.dto.room.RoomSaveDto;
import com.hotelManagementSystem.hotel.util.generics.dto.room.RoomUpdateDto;
import com.hotelManagementSystem.hotel.util.generics.service.CommonService;

import java.util.List;

public interface CustomerService extends CommonService<Customer, Integer> {
    List<Customer> findAll();

    Customer findDetailsById(Integer id);

    Customer update(Customer t, Integer id);

    Customer deleteById(Integer id);

    Customer create(Customer t);

    String updateProfile(UpdateProfile updateProfile, int id);

    String changeUserNamePassword(UserNamePasswordUpdateDto updateDto, int id);

    String saveCustomer(CustomerSaveDto customerDto);
}
