package com.example.bus_reservation_system.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.bus_reservation_system.entity.BusScheduleDays;
import com.example.bus_reservation_system.entity.BusScheduleDays.BusScheduleDaysId;

@Repository
public interface BusScheduleDay extends JpaRepository<BusScheduleDays, BusScheduleDaysId>{

    @Query("SELECT bsd FROM BusScheduleDays bsd WHERE bsd.id.busSchedule = :routeId AND bsd.id.dayOfWeek = :dayOfWeek")
    List<BusScheduleDays> findByRouteIdAndDayOfWeek(Long routeId, String dayOfWeek);


}
