package com.hotelManagementSystem.hotel.service.impl;

import com.hotelManagementSystem.hotel.exception.NotFoundException;
import com.hotelManagementSystem.hotel.model.Booking;
import com.hotelManagementSystem.hotel.model.Customer;
import com.hotelManagementSystem.hotel.model.Room;
import com.hotelManagementSystem.hotel.service.BookingService;
import com.hotelManagementSystem.hotel.service.CustomerService;
import com.hotelManagementSystem.hotel.service.RoomService;
import com.hotelManagementSystem.hotel.util.generics.dto.booking.BookingSaveDto;
import com.hotelManagementSystem.hotel.util.generics.repository.BookingRepository;
import com.hotelManagementSystem.hotel.util.generics.service.impl.CommonServiceImpl;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingServiceImpl extends CommonServiceImpl<Booking, Integer, BookingRepository> implements BookingService {
    private final Logger log = LoggerFactory.getLogger(BookingServiceImpl.class);
    private final RoomService roomService;
    private final CustomerService customerService;

    public BookingServiceImpl(BookingRepository repository, RoomService roomService, CustomerService customerService) {
        super(repository);
        this.roomService = roomService;
        this.customerService = customerService;
    }

    @Override
    public List<Booking> findAll() {
        return super.findAll();
    }

    @Override
    public Booking findDetailsById(Integer integer) {
        return super.findDetailsById(integer);
    }

    @Override
    public Booking update(Booking booking, Integer integer) {
        return super.update(booking, integer);
    }

    @Override
    public Booking deleteById(Integer integer) {
        return super.deleteById(integer);
    }

    @Transactional
    @Override
    public Booking saveBookingDetails(BookingSaveDto bookingSaveDto) {
        Room roomDetails = roomService.findDetailsById(bookingSaveDto.getRoomId());
        Customer customerDetails = customerService.findDetailsById(bookingSaveDto.getCustomerId());
        if (roomDetails.isRoomAvailable() && customerDetails != null) {
            log.info("Customer ;{} And Room : {} Available ", customerDetails.getCustomerName(), roomDetails.getRoomId());
            Booking bookingSave = new Booking(
                    bookingSaveDto.getOutDate(),
                    bookingSaveDto.getInDate(),
                    roomDetails,
                    customerDetails
            );
            repository.save(bookingSave);
            roomService.updateAvailability(roomDetails.getRoomId(), false);
            log.info("Booking Saved Successfully ");
            return bookingSave;
        } else {
            throw new NotFoundException(" Details Mismatch");
        }
    }

    @Override
    public Booking changeInOutDate(LocalDate inDate, LocalDate outDate, int bookingId) {
        Booking booking = repository.findById(bookingId).orElseThrow(() -> new NotFoundException("Not Found Booking Data For This ID: " + bookingId));
        booking.setInDate(inDate);
        booking.setOutDate(outDate);
        return repository.save(booking);
    }

    @Override
    public Booking extendOutdate(LocalDate outDate, int bookingId) {
        Booking booking = repository.findById(bookingId).orElseThrow(() -> new NotFoundException("Not Found Booking Data For This ID: " + bookingId));
        booking.setOutDate(outDate);
        return repository.save(booking);
    }

    @Override
    public Booking cancelBooking(Integer id) {
        Booking booking = repository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Booking Details"));
        if (booking != null) {
            roomService.updateAvailability(booking.getRoom().getRoomId(), true);
            repository.deleteByIdNative(id);
        }
        return booking;

    }
}
