package com.hotelManagementSystem.hotel.schedular;

import com.hotelManagementSystem.hotel.model.Booking;
import com.hotelManagementSystem.hotel.service.BookingService;
import com.hotelManagementSystem.hotel.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RoomAvailableUpdateBeforeEndDate {
    private final Logger log = LoggerFactory.getLogger(RoomAvailableUpdateBeforeEndDate.class);
    private final RoomService roomService;
    private final BookingService bookingService;
    // pending Features For Change The Active Status Of Booking On Booking Out Date On Scheduling date its  change
//    @Scheduled(fixedRate = 1000 * 60*60*24)
    public void autoUpdateAvailability() {
        log.info("Start Scheduler For Checked Expired report !");
        List<Booking> bookingExpired = bookingService.checkBookingExpired();
        log.info("Get The Expired Details Of Booking  !");
        if (!bookingExpired.isEmpty()) {
            bookingExpired.forEach(ex -> {
                roomService.updateAvailability(ex.getRoom().getRoomId(), true);
                log.info("Now Available For Booking New Room :{}", ex.getRoom().getRoomId());
                bookingService.changeBookingActiveStatus(ex.getBookingId(),false);
                log.info("Cancel Booking : {}", ex.getCustomer().getCustomerName());
            });
        }
    }
}
