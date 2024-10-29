package com.hotelManagementSystem.hotel.service.impl;

import com.hotelManagementSystem.hotel.model.Booking;
import com.hotelManagementSystem.hotel.model.Customer;
import com.hotelManagementSystem.hotel.service.BookingService;
import com.hotelManagementSystem.hotel.service.CustomerService;
import com.hotelManagementSystem.hotel.util.generics.repository.BookingRepository;
import com.hotelManagementSystem.hotel.util.generics.repository.CustomerRepository;
import com.hotelManagementSystem.hotel.util.generics.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BookingServiceImpl extends CommonServiceImpl<Booking, Integer, BookingRepository> implements BookingService {
    public BookingServiceImpl(BookingRepository repository) {
        super(repository);
    }

    @Override
    public List<Booking> findAll() {
        return super.findAll();
    }

    @Override
    public Booking findDetailsById(Integer integer) {
        return super.findDetailsById(integer);
    }

    @Override
    public Booking update(Booking booking, Integer integer) {
        return super.update(booking, integer);
    }

    @Override
    public Booking deleteById(Integer integer) {
        return super.deleteById(integer);
    }
}
