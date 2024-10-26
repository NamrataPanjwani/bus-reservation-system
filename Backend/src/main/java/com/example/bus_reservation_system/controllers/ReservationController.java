package com.example.bus_reservation_system.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.bus_reservation_system.entity.ReservationDto;
import com.example.bus_reservation_system.entity.RevenueReport;
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

     @GetMapping("/getTicket/{id}")
    public  Optional<Reservation> getReservation(@PathVariable("id") long id){
        return reservationService.getTicket(id);
    }

    @GetMapping("/getAllTicket/{busId}")
    public List<Reservation> getAllTicket(@PathVariable("busId") Iterable<Long> busId){
        return reservationService.getAllTicket(busId);
    }

    @PostMapping("/createTicket")
    public ResponseEntity<Reservation> createTicket(@RequestBody ReservationDto reservation){
        Reservation newTicket = reservationService.createTicket(reservation);
        return new ResponseEntity<>(newTicket, HttpStatus.OK);
    }


    @DeleteMapping("/deleteTicket/{id}")
    public void deleteTicket(@PathVariable("id") long id){
        reservationService.deleteTicket(id);}


    @GetMapping("/search/userId/{userId}/busId/{busId}")
    public List<Reservation> getReservations(
            @PathVariable("userId") long userId,
            @PathVariable("busId") long busId) {
        return reservationService.getReservationsByUserIdAndBusId(userId,busId);
    }



    @GetMapping("/bookedSeats/{bus_id}/{date}")
    public List<Integer> getBookedSeats(@PathVariable("bus_id") long bus_id,
                                        @PathVariable("date") String date){
         return reservationService.getBookedSeats(bus_id,date);
    }

    @GetMapping("/total-revenue/rajvi-travels")
    public ResponseEntity<Map<String, Object>> getTotalRevenueForRajviTravels() {
        List<RevenueReport> report = reservationService.getTotalRevenueReport();


        double totalRevenue = report.stream()
                .mapToDouble(RevenueReport::getTotalRevenue)
                .sum();


        Map<String, Object> response = new HashMap<>();
        response.put("report", report);
        response.put("totalRevenue", totalRevenue);
        System.out.println("Response:"+response);
        return ResponseEntity.ok(response);
    }
}
