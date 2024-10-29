package com.hotelManagementSystem.hotel.util.generics.service.impl;

import com.hotelManagementSystem.hotel.exception.NotFoundException;
import com.hotelManagementSystem.hotel.util.generics.repository.CommonRepository;
import com.hotelManagementSystem.hotel.util.generics.service.CommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CommonServiceImpl<T, ID, R extends CommonRepository<T, ID>> implements CommonService<T, ID> {
    protected final R repository;
    private final Logger log = LoggerFactory.getLogger(this.getClass());


    public CommonServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public List<T> findAll() {
       log.info("Found All Details : {}",this.getClass().getSimpleName());
        return repository.findAll();
    }

    @Override
    public T findDetailsById(ID id) {
        log.info("Found All Details By ID : {} ",id);
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Details"));
    }

    @Override
    public T update(T t, ID id) {
        log.info("Update Details : {}",this.getClass().getSimpleName());
        return t;
    }

    @Override
    public T deleteById(ID id) {
        log.info("Deleted All Details By ID : {}",id);
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Delete Failed"));
    }


}
