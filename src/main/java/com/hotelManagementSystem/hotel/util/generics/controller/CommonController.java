package com.hotelManagementSystem.hotel.util.generics.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CommonController<T,ID> {
    ResponseEntity<List<T>> getAll() throws Exception;

    ResponseEntity<String> findById(ID id) throws Exception;

    ResponseEntity<T> update(T t, ID id) throws Exception;

    ResponseEntity<T> delete(ID id) throws Exception;

    ResponseEntity<T> add(T t) throws Exception;

}
