package com.example.bus_reservation_system.controllers;

import com.example.bus_reservation_system.entity.BusSchedule;
import com.example.bus_reservation_system.entity.BusScheduleDays;
import com.example.bus_reservation_system.repositories.BusScheduleDao;
import com.example.bus_reservation_system.services.BusScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/busSchedule")
public class BusScheduleController {

    @Autowired
    // private BusScheduleDao busScheduleDao;

    private final BusScheduleService busScheduleService;

    @Autowired
    public BusScheduleController (BusScheduleService busScheduleService){
        this.busScheduleService=busScheduleService;
    }

    @GetMapping("/route/{routeId}/date/{dateStr}")
    public List<BusScheduleDays> getBusesByRoute(@PathVariable Long routeId, @PathVariable String dateStr) {
        return busScheduleService.getBusesByRoute(routeId, dateStr);
    }

    // @GetMapping("/route/{routeId}/date/{dateStr}")
    // public List<BusSchedule> getBusesByRoute(@PathVariable Long routeId, @PathVariable String dateStr) {
    //     // LocalDate date = LocalDate.parse(dateStr);

    //     return busScheduleService.getBusesByRoute(routeId,dateStr);
    // }

    // @GetMapping("/search")
    // public List<BusSchedule> searchBuses(
    //         @RequestParam String source,
    //         @RequestParam String destination,
    //         @RequestParam String date) {
        
    //     LocalDate searchDate = LocalDate.parse(date); // Convert string to LocalDate
    //     return busScheduleService.findAvailableBuses(source, destination, searchDate);
    // }

    @GetMapping("/list")
    public List<BusSchedule> findAll(){
        return busScheduleService.findAll();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<BusSchedule> getBusScheduleById(@PathVariable("id") long id){
        BusSchedule schedule = busScheduleService.findById(id);
        return new ResponseEntity<>(schedule, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<BusSchedule> addBusSchedule(@RequestBody BusSchedule busSchedule){
        BusSchedule newBusSchedule = busScheduleService.save(busSchedule);
        return new ResponseEntity<>(newBusSchedule, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<BusSchedule> updateBusSchedule(@PathVariable long id, @RequestBody BusSchedule busSchedule){
        return busScheduleService.updateBusSchedule(id,busSchedule);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BusSchedule> deleteBusScheduleById(@PathVariable long id){
        busScheduleService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
