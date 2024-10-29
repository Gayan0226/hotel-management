package com.hotelManagementSystem.hotel.util.generics.service;

import java.util.List;

public interface CommonService<T, ID> {
    List<T> findAll();

    String findDetailsById(ID id);

    T update(T t, ID id);

    T deleteById(ID id);

    T create(T t);
}
