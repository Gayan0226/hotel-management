package com.hotelManagementSystem.hotel.util.generics.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotelManagementSystem.hotel.exception.NotFoundException;
import com.hotelManagementSystem.hotel.util.generics.repository.CommonRepository;
import com.hotelManagementSystem.hotel.util.generics.service.CommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;

public class CommonServiceImpl<T, ID, R extends CommonRepository<T, ID>> implements CommonService<T, ID> {
    protected final R repository;
    private final Logger log = LoggerFactory.getLogger(this.getClass());


    public CommonServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public List<T> findAll() {
        List<T> allData = repository.findAll();
        log.info("Find All Data : {}", allData);
        return (!allData.isEmpty()) ? allData : Collections.emptyList();
    }

    @Override
    public T findDetailsById(ID id) {
        log.info("Find Details By ID : {} ", id);
        T foundDetails = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not Found Details"));
        log.info("Found Details : {}", foundDetails);
        return foundDetails;
    }

    @Override
    public T update(T t, ID id) {
        T foundDetails = this.findDetailsById(id);
        T updateObj = null;
        try {
            updateObj = new ObjectMapper()
                    .readerForUpdating(foundDetails)
                    .readValue(new ObjectMapper()
                            .writeValueAsString(t));
        } catch (JsonProcessingException e) {
            log.debug("There Is Some Issues ");
            throw new RuntimeException(e);
        }
        log.info("updated By Id : {} Updated Details : {}", id, t);
        return repository.saveAndFlush(updateObj);
    }

    @Override
    public T deleteById(ID id) {
        T deleteDetails = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Delete Failed"));
        log.info("Found Details : {} By {}", deleteDetails, id);
        repository.delete(deleteDetails);
        return deleteDetails;
    }


}
