package com.hotelManagementSystem.hotel.util.generics.repository;

import com.hotelManagementSystem.hotel.model.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CommonRepository<Admin, Integer> {
}
