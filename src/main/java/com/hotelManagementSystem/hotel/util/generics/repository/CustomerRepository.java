package com.hotelManagementSystem.hotel.util.generics.repository;

import com.hotelManagementSystem.hotel.model.Customer;
import com.hotelManagementSystem.hotel.model.Room;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CommonRepository<Customer,Integer> {
}
