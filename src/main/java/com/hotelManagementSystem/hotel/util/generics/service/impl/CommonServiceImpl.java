package com.hotelManagementSystem.hotel.util.generics.service.impl;

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
    public String findDetailsById(ID id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Delete Successful!";
        } else {
            return "delete fail!";
        }
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
