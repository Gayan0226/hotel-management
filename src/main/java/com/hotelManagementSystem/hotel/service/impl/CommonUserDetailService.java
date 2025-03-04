package com.hotelManagementSystem.hotel.service.impl;

import com.hotelManagementSystem.hotel.configurations.AdminPrinciple;
import com.hotelManagementSystem.hotel.configurations.CustomerPrinciple;
import com.hotelManagementSystem.hotel.model.Admin;
import com.hotelManagementSystem.hotel.model.Customer;
import com.hotelManagementSystem.hotel.util.generics.dto.auth.LoginDto;
import com.hotelManagementSystem.hotel.util.generics.repository.AdminRepository;
import com.hotelManagementSystem.hotel.util.generics.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CommonUserDetailService implements UserDetailsService {
    private final AdminRepository adminRepository;
    private final AuthenticationManager authenticationManager;
    private final CustomerRepository customerRepository;
    private final JWTService jwtService;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    public CommonUserDetailService(AdminRepository adminRepository, AuthenticationManager authenticationManager, CustomerRepository customerRepository, JWTService jwtService) {
        this.adminRepository = adminRepository;
        this.authenticationManager = authenticationManager;
        this.customerRepository = customerRepository;
        this.jwtService = jwtService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminRepository.findAdminsByUsername(username);
        Customer customer = customerRepository.findCustomerByUserName(username);
        if (admin == null && customer == null) throw new RuntimeException("Credential Invalid !");
        else {
            if (admin != null) {
                return new AdminPrinciple(admin);
            } else {
                return new CustomerPrinciple(customer);
            }
        }
    }


    public String isValidUser(LoginDto auth) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                auth.getUserName(),
                auth.getPassword()
        ));
        if (authenticate.isAuthenticated()) {
            LOGGER.info("User is  Valid");
            return jwtService.generateToken(auth.getUserName());
        } else {
            throw new RuntimeException("Invalid Credential !");
        }
    }
}
