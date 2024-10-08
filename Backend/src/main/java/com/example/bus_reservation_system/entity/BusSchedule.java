package com.example.bus_reservation_system.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import java.time.LocalDate;
import java.time.DayOfWeek;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference(value = "BusSchedule-Bus") 
    private Bus bus;

    @ManyToOne
    @JoinColumn(nullable = false,name = "route_id")
    @JsonBackReference(value = "BusSchedule-Route") 
    private Route route;

    // @ElementCollection
    // @Enumerated(EnumType.STRING)
    // @CollectionTable(name = "bus_schedule_days", joinColumns = @JoinColumn(name = "bus_schedule_id"))
    // @Column(name = "day_of_week")

    // @Enumerated(EnumType.STRING)
    // @Column(nullable = false)
    // private Set<DayOfWeek> availableDays;

    // @ElementCollection(targetClass = DayOfWeek.class)
    // @Enumerated(EnumType.STRING)
    // @Column(nullable = false)
    // private List<DayOfWeek> availableDays= new ArrayList<DayOfWeek>();

    
    @Column(nullable = false)
    private Time departureTime;

    @Column(nullable = false)
    private Time arrivalTime;

    @Column(nullable = false)
    private Integer availableSeats;

    @Column(nullable = false)
    private Double pricePerSeat;

    // @Column(nullable = false)
    // private LocalDate date;

}
