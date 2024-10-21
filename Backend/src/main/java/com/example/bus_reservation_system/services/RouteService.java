package com.example.bus_reservation_system.services;

import com.example.bus_reservation_system.entity.Route;
import com.example.bus_reservation_system.repositories.RouteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import java.util.Optional;

@Service
public class RouteService {
    private final RouteDao routeDao;

    @Autowired
    public RouteService(RouteDao routeRepo) {
        this.routeDao = routeRepo;
    }

    public List<Route> findAll() {
        return routeDao.findAll();
    }

    public Optional<Route> findById(long theId) {
        return routeDao.findById(theId);
    }

    public Route save(Route route) {
        return routeDao.save(route);
    }

    public ResponseEntity<Route> updateRoute(@PathVariable long id, @RequestBody Route route) {
        Optional<Route> existingRouteOpt = routeDao.findById(id);

        if (existingRouteOpt.isPresent()) {
            Route existingRoute = existingRouteOpt.get();

            existingRoute.setSource(route.getSource());
            existingRoute.setDestination(route.getDestination());

            Route updatedRoute = routeDao.save(existingRoute);
            return ResponseEntity.ok(updatedRoute);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public void deleteById(long theId) {
        routeDao.deleteById(theId);
    }
}
