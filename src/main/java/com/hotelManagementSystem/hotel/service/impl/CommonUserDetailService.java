package com.hotelManagementSystem.hotel.service.impl;

import com.hotelManagementSystem.hotel.configurations.AdminPrinciple;
import com.hotelManagementSystem.hotel.configurations.CustomerPrinciple;
import com.hotelManagementSystem.hotel.model.Admin;
import com.hotelManagementSystem.hotel.model.Customer;
import com.hotelManagementSystem.hotel.util.generics.repository.AdminRepository;
import com.hotelManagementSystem.hotel.util.generics.repository.CustomerRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CommonUserDetailService implements UserDetailsService {
    private final AdminRepository adminRepository;
    private final CustomerRepository customerRepository;

    public CommonUserDetailService(AdminRepository adminRepository, CustomerRepository customerRepository) {
        this.adminRepository = adminRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin=adminRepository.findAdminsByUsername(username);
        Customer customer=customerRepository.findCustomerByUserName(username);
        if(admin==null && customer==null)throw new RuntimeException("Credential Invalid !");
        else{
            if(admin!=null){
                return new AdminPrinciple(admin);
            }
            else {
                return new CustomerPrinciple(customer);
            }
        }
    }
}
