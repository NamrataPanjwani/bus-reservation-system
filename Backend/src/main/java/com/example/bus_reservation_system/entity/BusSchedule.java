package com.example.bus_reservation_system.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.sql.Time;
import java.util.Set;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Data
@Table(name = "Bus_schedule")
public class BusSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @ManyToOne
    @JoinColumn(name = "bus_id", nullable = false)
    @JsonManagedReference // This will be serialized
    private Bus bus;

    @ManyToOne
    @JoinColumn(nullable = false,name = "route_id")
    private Route route;

    // @ElementCollection
    // @Enumerated(EnumType.STRING)
    // @CollectionTable(name = "bus_schedule_days", joinColumns = @JoinColumn(name = "bus_schedule_id"))
    // @Column(name = "day_of_week")

    // @Enumerated(EnumType.STRING)
    // @Column(nullable = false)
    // private Set<DayOfWeek> availableDays;

    @Column(nullable = false)
    private String availableDays;

    
    @Column(nullable = false)
    private Time departureTime;

    @Column(nullable = false)
    private Time arrivalTime;

    @Column(nullable = false)
    private Integer availableSeats;

    @Column(nullable = false)
    private Double pricePerSeat;

    @Column(nullable = false)
    private LocalDate date;

}
