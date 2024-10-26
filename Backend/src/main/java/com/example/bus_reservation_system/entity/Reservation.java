package com.example.bus_reservation_system.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="user_id",nullable=false)
    private long user_id;

    @ManyToOne
    @JoinColumn(name = "bus_id",nullable = false)
    private Bus bus;

    @Column(nullable = false)
    private String reservationDate;

    @Column(nullable = false)
    private int seatNumber;

    @Column(nullable = false)
    private long bookingId;
}
