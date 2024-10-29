package com.hotelManagementSystem.hotel.util.generics.service.impl;

import com.hotelManagementSystem.hotel.exception.NotFoundException;
import com.hotelManagementSystem.hotel.util.generics.mapper.RoomMap;
import com.hotelManagementSystem.hotel.util.generics.repository.CommonRepository;
import com.hotelManagementSystem.hotel.util.generics.service.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

public class CommonServiceImpl<T, ID, R extends CommonRepository<T, ID>> implements CommonService<T, ID> {
    protected final R repository;
    public CommonServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public T findDetailsById(ID id) {
        return repository.findById(id).orElseThrow(()->new NotFoundException("Not Found Details"));
    }

    @Override
    public T update(T t, ID id) {
        return null;
    }

    @Override
    public T deleteById(ID id) {
        return null;
    }

    @Override
    public T create(T t) {
        return null;
    }

}
