package com.example.bus_reservation_system.services;

import com.example.bus_reservation_system.entity.BusSchedule;
import com.example.bus_reservation_system.entity.BusScheduleDays;
import com.example.bus_reservation_system.repositories.BusScheduleDao;
import com.example.bus_reservation_system.repositories.BusScheduleDay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BusScheduleService {

    private final BusScheduleDao busScheduleDao;

    private final BusScheduleDay busScheduleDay;

    @Autowired
    public BusScheduleService(BusScheduleDao busScheduleRepo, BusScheduleDay busScheduleDay) {
        this.busScheduleDao = busScheduleRepo;
        this.busScheduleDay = busScheduleDay;
    }

    // public List<BusSchedule> findAvailableBuses(String source, String destination, LocalDate date) {
    //     // Fetch schedules based on the source, destination, and date
    //     return busScheduleDao.findBySourceDestinationAndDate(source, destination, date);
    // }



    public List<BusScheduleDays> getBusesByRoute(Long routeId, String dateStr) {
        LocalDate date = LocalDate.parse(dateStr);
        DayOfWeek dayOfWeek = date.plusDays(1).getDayOfWeek();

        String dayOfWeekStr = dayOfWeek.name();


        System.out.println("route ID: " + routeId + " date: " + date + " str: " + dateStr+ "day of week: " + dayOfWeek);
        return busScheduleDay.findByRouteIdAndDayOfWeek(routeId, dayOfWeekStr);
    }
    
    // public List<BusSchedule> getBusesByRoute(Long routeId, String dateStr) {
    //     LocalDate date = LocalDate.parse(dateStr);
    //     return busScheduleDao.findByRouteIdAndAvailableDays(routeId, date.getDayOfWeek());
    // }

    public List<BusSchedule> findAll() {
        return busScheduleDao.findAll();
    }

    public BusSchedule findById(long theId) {
        Optional<BusSchedule> result = busScheduleDao.findById(theId);

        BusSchedule busSchedule = null;

        if (result.isPresent()) {
            busSchedule = result.get();
        } else {

            throw new RuntimeException("Did not find busSchedule with id: " + theId);
        }

        return busSchedule;
    }

    public BusSchedule save(BusSchedule busSchedule) {
        return busScheduleDao.save(busSchedule);
    }


    public void deleteById(long theId) {
        busScheduleDao.deleteById(theId);
    }

    public ResponseEntity<BusSchedule> updateBusSchedule(@PathVariable long id, @RequestBody BusSchedule busSchedule){
        busSchedule.setPricePerSeat(busSchedule.getPricePerSeat());
        busSchedule.setBus(busSchedule.getBus());
        busSchedule.setAvailableSeats(busSchedule.getAvailableSeats());
        busSchedule.setRoute(busSchedule.getRoute());
        busSchedule.setDepartureTime(busSchedule.getDepartureTime());
        busSchedule.setArrivalTime(busSchedule.getArrivalTime());
        // busSchedule.setAvailableDays(busSchedule.getAvailableDays());

        BusSchedule updateBusSchedule = busScheduleDao.save(busSchedule);
        return ResponseEntity.ok(updateBusSchedule);
    }


}






