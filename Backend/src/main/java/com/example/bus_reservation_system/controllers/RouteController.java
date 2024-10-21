package com.example.bus_reservation_system.controllers;

import com.example.bus_reservation_system.entity.Route;
import com.example.bus_reservation_system.repositories.RouteDao;
import com.example.bus_reservation_system.services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/route")
public class RouteController {


    @Autowired
    private RouteDao routeDao;

    private RouteService routeService;

    public RouteController(RouteService routeService){
        this.routeService=routeService;
    }


    @GetMapping("/list")
    public List<Route> findAll(){
        System.out.println("Route");
        return routeService.findAll();
    }

    @GetMapping("/find/{id}")
    public Optional<Route> getRouteById(@PathVariable long id){
        return routeService.findById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Route> addRoute(@RequestBody Route route){
        Route newRoute = routeService.save(route);
        return new ResponseEntity<>(newRoute,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Route> updateRoute(@PathVariable long id, @RequestBody Route route){
        return routeService.updateRoute(id, route);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Route> deleteRouteById(@PathVariable long id){
        routeService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
