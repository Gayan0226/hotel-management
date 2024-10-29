package com.hotelManagementSystem.hotel.util.generics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
@NoRepositoryBean
public interface CommonRepository<T,ID> extends JpaRepository<T,ID> {

}
