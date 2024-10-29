package com.hotelManagementSystem.hotel.controller.impl;

import com.hotelManagementSystem.hotel.controller.CustomerController;
import com.hotelManagementSystem.hotel.model.Customer;
import com.hotelManagementSystem.hotel.service.CustomerService;
import com.hotelManagementSystem.hotel.util.generics.controller.impl.CommonControllerImpl;
import com.hotelManagementSystem.hotel.util.generics.dto.UserNamePasswordUpdateDto;
import com.hotelManagementSystem.hotel.util.generics.dto.customer.CustomerSaveDto;
import com.hotelManagementSystem.hotel.util.generics.dto.customer.UpdateProfile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerControllerImpl extends CommonControllerImpl<Customer, Integer, CustomerService> implements CustomerController {

    @Override
    public ResponseEntity<List<Customer>> getAll() throws Exception {
        return super.getAll();
    }

    @Override
    public ResponseEntity<Customer> findById(Integer integer) throws Exception {
        return super.findById(integer);
    }

    @Override
    public ResponseEntity<Customer> update(Customer customer, Integer integer) throws Exception {
        return super.update(customer, integer);
    }

    @Override
    public ResponseEntity<Customer> delete(Integer integer) throws Exception {
        return super.delete(integer);
    }

    @Override
    public ResponseEntity<String> updateProfileDetails(int id, UpdateProfile updateProfile) throws Exception {
        return new ResponseEntity<String>(service.updateProfile(updateProfile, id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> changeUserNamePassword(int id, UserNamePasswordUpdateDto updateDto) throws Exception {
        return new ResponseEntity<String>(service.changeUserNamePassword(updateDto, id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> saveCustomer(CustomerSaveDto customerDto) throws Exception {
        return new ResponseEntity<String>(service.saveCustomer(customerDto), HttpStatus.OK);
    }

    public CustomerControllerImpl(CustomerService service) {
        super(service);
    }
}
