package com.hotelManagementSystem.hotel.exception;

public class DuplicateEntryException extends RuntimeException{
        public DuplicateEntryException(String message) {
            super(message);
        }
}
