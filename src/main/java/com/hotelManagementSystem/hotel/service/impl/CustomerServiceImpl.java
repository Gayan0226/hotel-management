package com.hotelManagementSystem.hotel.service.impl;

import com.hotelManagementSystem.hotel.exception.NotFoundException;
import com.hotelManagementSystem.hotel.model.Customer;
import com.hotelManagementSystem.hotel.service.CustomerService;
import com.hotelManagementSystem.hotel.util.generics.dto.UserNamePasswordUpdateDto;
import com.hotelManagementSystem.hotel.util.generics.dto.customer.CustomerSaveDto;
import com.hotelManagementSystem.hotel.util.generics.dto.customer.UpdateProfile;
import com.hotelManagementSystem.hotel.util.generics.repository.CustomerRepository;
import com.hotelManagementSystem.hotel.util.generics.service.impl.CommonServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CustomerServiceImpl extends CommonServiceImpl<Customer, Integer, CustomerRepository> implements CustomerService {

    @Autowired
    ModelMapper modelMapper;

    public CustomerServiceImpl(CustomerRepository repository) {
        super(repository);
    }

    @Override
    public Customer create(Customer t) {
        return null;
    }

    @Override
    public String updateProfile(UpdateProfile updateProfile, int id) {
        Customer customerToUpdate = repository.findById(id).orElseThrow(() -> new NotFoundException("NotFound"));
        customerToUpdate.setCustomerName(updateProfile.getCustomerName());
        customerToUpdate.setIdNumber(updateProfile.getIdNumber());
        customerToUpdate.setContactNumber(updateProfile.getContactNumber());
        repository.save(customerToUpdate);
        return "Update Profile Successfully";
    }

    @Override
    public String changeUserNamePassword(UserNamePasswordUpdateDto updateDto, int id) {
        Customer customerToUpdate = repository.findById(id).orElseThrow(() -> new NotFoundException("NotFound"));
        customerToUpdate.setPassword(updateDto.getPassword());
        customerToUpdate.setUserName(updateDto.getUserName());
        return "Changed Password And UserName";
    }

    @Override
    public String saveCustomer(CustomerSaveDto customerDto) {
        Customer saveCustomer = modelMapper.map(customerDto, Customer.class);
        repository.save(saveCustomer);
        return "Save Customer Successfully";
    }
}
