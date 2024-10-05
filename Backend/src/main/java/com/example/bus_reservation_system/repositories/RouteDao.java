package com.example.bus_reservation_system.repositories;


import com.example.bus_reservation_system.entity.Route;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteDao extends JpaRepository<Route,Long> {
    List<Route> findBySourceAndDestination(String source, String destination);
}
