package com.example.bus_reservation_system.entity;


import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Data
@Table(name = "BusTable")
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bus_number", unique = true, nullable = false)
    private String busNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "bus_type", nullable = false)
    private BusType busType;

    @Column(nullable = false)
    private Integer capacity;

    @Column(name = "bus_name")
    private String busName;


}
