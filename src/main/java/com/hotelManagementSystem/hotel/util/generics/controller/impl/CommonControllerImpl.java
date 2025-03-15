package com.hotelManagementSystem.hotel.util.generics.controller.impl;

import com.hotelManagementSystem.hotel.util.generics.controller.CommonController;
import com.hotelManagementSystem.hotel.util.generics.service.CommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public class CommonControllerImpl<T, ID, S extends CommonService<T, ID>> implements CommonController<T, ID> {

    protected final S service;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public CommonControllerImpl(S service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<T>> getAll() throws Exception {
        log.info("Requested Get All Data !");
        List<T> data = service.findAll();
        log.info("response data {}", data);
        return new ResponseEntity<List<T>>(data, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<T> findById(@PathVariable("id") ID id) throws Exception {
        log.info("Requested Find Data By id :{}", id);
        T data = service.findDetailsById(id);
        log.info("Response find data : {}", data);
        return new ResponseEntity<T>(data, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<T> update(@RequestBody T t, @PathVariable("id") ID id) throws Exception {
        log.info("Requested Update Data By id :{}", id);
        T data = service.update(t, id);
        log.info("Response updated data : {}", data);
        return new ResponseEntity<T>(data, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<T> delete(@PathVariable("id") ID id) throws Exception {
        log.info("Requested Delete  data By : {}", id);
        T data = service.deleteById(id);
        log.info("Response Deleted data : {}", data);
        return new ResponseEntity<T>(data, HttpStatus.OK);
    }
}
