package com.hotelManagementSystem.hotel.util.generics.controller.impl;

import com.hotelManagementSystem.hotel.util.generics.controller.CommonController;
import com.hotelManagementSystem.hotel.util.generics.service.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


public class CommonControllerImpl<T, ID, S extends CommonService<T, ID>> implements CommonController<T, ID> {

    protected final S service;

    public CommonControllerImpl(S service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<T>> getAll() throws Exception {
        return new ResponseEntity<List<T>>(service.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<T> findById(@PathVariable("id") ID id) throws Exception {
        return new ResponseEntity<T>(service.findDetailsById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<T> update(@RequestBody T t, @PathVariable("id") ID id) throws Exception {
        return new ResponseEntity<T>(service.update(t, id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<T> delete(@PathVariable("id") ID id) throws Exception {
        return new ResponseEntity<T>(service.deleteById(id), HttpStatus.OK);
    }


}
