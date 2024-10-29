package com.hotelManagementSystem.hotel.util.generics.service.impl;

import com.hotelManagementSystem.hotel.util.generics.repository.CommonRepository;
import com.hotelManagementSystem.hotel.util.generics.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class CommonServiceImpl<T, ID, R extends CommonRepository<T, ID>> implements CommonService<T, ID> {

    protected final R repository;
    CommonServiceImpl(R repository){
        this.repository=repository;
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
