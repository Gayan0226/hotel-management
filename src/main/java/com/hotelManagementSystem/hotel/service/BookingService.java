package com.hotelManagementSystem.hotel.service;
import com.hotelManagementSystem.hotel.model.Booking;
import com.hotelManagementSystem.hotel.model.Customer;
import com.hotelManagementSystem.hotel.util.generics.service.CommonService;

import java.util.List;

public interface BookingService extends CommonService<Booking, Integer> {
    List<Booking> findAll();

    Booking findDetailsById(Integer id);

    Booking update(Booking t, Integer id);

    Booking deleteById(Integer id);



}
