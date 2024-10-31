package com.hotelManagementSystem.hotel.util.generics.dto.report;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class PdfReportData {
    private String customerName;
    private String contactNumber;
    private Long idNumber;
    private Integer roomId;
    private LocalDate inDate;
    private LocalDate outDate;
}
