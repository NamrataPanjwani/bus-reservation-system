package com.example.bus_reservation_system.entity;

import lombok.Data;

@Data
public class ReservationDto {
    private long user_id;
    private long bus_id;
    private String reservationDate;
    private int seatNumber;
    private long bookingId;
}
