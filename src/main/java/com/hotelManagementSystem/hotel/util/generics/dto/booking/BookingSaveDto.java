package com.hotelManagementSystem.hotel.util.generics.dto.booking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingSaveDto {
    private LocalDate outDate;
    private LocalDate inDate;
    private int roomId;
    private int customerId;
}
