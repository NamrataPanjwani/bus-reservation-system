package com.example.bus_reservation_system.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.bus_reservation_system.entity.Reservation;
import com.example.bus_reservation_system.services.ReservationService;

@RestController
@RequestMapping("/api/seats")
@CrossOrigin(origins="http://localhost:4200")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @GetMapping("/getTicketById/{id}")
    public  Optional<Reservation> getReservation(@PathVariable("id") long id){
        return reservationService.getTicket(id);
    }

    @GetMapping("/getAllTicket/{busId}")
    public Optional<Reservation> getAllTicket(@PathVariable("busId") Long busId){
        return reservationService.getAllTicket(busId);
    }

    @GetMapping("/list")
    public List<Reservation> getAllTickets(){
        return reservationService.getAllReservations();
    }

    @PostMapping("/createTicket")
    public ResponseEntity<Reservation> createTicket(@RequestBody Reservation reservation){
        Reservation newTicket = reservationService.createTicket(reservation);
        return new ResponseEntity<>(newTicket, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable long id, @RequestBody Reservation reservation){
        return reservationService.updateReservation(id, reservation);
    }

    @DeleteMapping("/deleteTicket/{id}")
    public void deleteTicket(@PathVariable("id") long id){
        reservationService.deleteTicket(id);
    }
}
