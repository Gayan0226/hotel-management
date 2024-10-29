package com.hotelManagementSystem.hotel.util.generics.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfiguration {
    @Bean
    public ModelMapper modelMapperConfig() {
        return new ModelMapper();
    }

}
