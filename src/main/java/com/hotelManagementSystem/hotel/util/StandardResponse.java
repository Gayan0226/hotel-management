package com.hotelManagementSystem.hotel.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StandardResponse {
    private int code;
    private String message;
    private Object data;

}
