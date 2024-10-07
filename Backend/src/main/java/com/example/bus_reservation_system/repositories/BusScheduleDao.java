package com.example.bus_reservation_system.repositories;

import com.example.bus_reservation_system.entity.BusSchedule;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;

@Repository
public interface BusScheduleDao extends JpaRepository<BusSchedule, Long> {
     List<BusSchedule> findByRouteId(Long routeId);

     // List<BusSchedule> findBySourceDestinationAndDate(String source, String destination, LocalDate date);
}
