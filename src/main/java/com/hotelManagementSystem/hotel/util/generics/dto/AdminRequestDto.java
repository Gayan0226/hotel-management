package com.hotelManagementSystem.hotel.util.generics.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdminRequestDto {
    private String userName;
    private String password;
}
