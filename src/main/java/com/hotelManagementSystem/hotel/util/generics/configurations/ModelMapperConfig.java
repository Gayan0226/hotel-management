package com.hotelManagementSystem.hotel.util.generics.configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapperConfigurations(){
        return new ModelMapper();
    }
}
