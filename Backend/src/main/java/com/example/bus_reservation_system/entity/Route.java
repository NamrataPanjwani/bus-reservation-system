package com.example.bus_reservation_system.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Data
@Table(name = "Route")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String source;

    @Column(nullable = false)
    private String destination;

    // @OneToMany(mappedBy = "route")
    // @JsonBackReference
    // private List<BusSchedule> busSchedules;

}