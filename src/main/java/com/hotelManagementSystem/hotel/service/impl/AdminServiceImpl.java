package com.hotelManagementSystem.hotel.service.impl;

import com.hotelManagementSystem.hotel.model.Admin;
import com.hotelManagementSystem.hotel.service.AdminService;
import com.hotelManagementSystem.hotel.util.generics.dto.AdminRequestDto;
import com.hotelManagementSystem.hotel.util.generics.repository.AdminRepository;
import com.hotelManagementSystem.hotel.util.generics.service.impl.CommonServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl extends CommonServiceImpl<Admin, Integer, AdminRepository> implements AdminService {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public AdminServiceImpl(AdminRepository repository) {
        super(repository);
    }

    @Override
    public String createAdmin(AdminRequestDto admin) {
        try {
            Admin saveAdmin = repository.save(
                    new Admin(admin.getUserName(),
                            encoder.encode(admin.getPassword())
                    ));
            LOGGER.info("{} Saved Successful !",saveAdmin.getUsername());
            return saveAdmin.getUsername();
        } catch (Exception e) {
            LOGGER.debug("Admin Save Failed !");
            throw new RuntimeException(e);
        }
    }
}
