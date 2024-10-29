package com.hotelManagementSystem.hotel.util.generics.dto.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateProfile {
    private String customerName;
    private String password;
    private String userName;
    private String contactNumber;
    private Long idNumber;

}
