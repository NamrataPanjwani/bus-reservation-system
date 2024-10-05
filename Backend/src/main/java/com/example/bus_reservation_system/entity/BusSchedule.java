package com.example.bus_reservation_system.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.sql.Time;
import java.util.Set;

@Entity
@Data
@Table(name = "Bus_schedule")
public class BusSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false, name = "bus_id")
    private Bus bus;

    @ManyToOne
    @JoinColumn(nullable = false,name = "route_id")
    private Route route;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "bus_schedule_days", joinColumns = @JoinColumn(name = "bus_schedule_id"))
    @Column(name = "day_of_week")
    private Set<DayOfWeek> availableDays;

    @Column(nullable = false)
    private Time departureTime;

    @Column(nullable = false)
    private Time arrivalTime;

    @Column(nullable = false)
    private Integer availableSeats;

    @Column(nullable = false)
    private Double pricePerSeat;

}
