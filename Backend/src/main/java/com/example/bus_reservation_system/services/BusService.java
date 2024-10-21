package com.example.bus_reservation_system.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.bus_reservation_system.entity.Bus;
import com.example.bus_reservation_system.repositories.BusDao;


@Service
public class BusService {
    @Autowired
    BusDao busDao;

    public Bus createBus(Bus bus){
        return busDao.save(bus);
    }

    public Optional<Bus> findBus(long id){
        return busDao.findById(id);

    }
    public List<Bus> getAllBus(){
        return busDao.findAll();
    }

    public void deleteBus(long id){
        busDao.deleteById(id);
    }

    public ResponseEntity<Bus> updateBus(long id, Bus bus) {
        Optional<Bus> existingBusOpt = busDao.findById(id);

        if (existingBusOpt.isPresent()) {
            Bus existingBus = existingBusOpt.get();

            existingBus.setBusNumber(bus.getBusNumber());
            existingBus.setBusType(bus.getBusType());
            existingBus.setArrTime(bus.getArrTime());
            existingBus.setDeptTime(bus.getDeptTime());
            existingBus.setRoute_id(bus.getRoute_id());
            existingBus.setOperator(bus.getOperator());
            existingBus.setPrice(bus.getPrice());

            Bus updatedBus = busDao.save(existingBus);
            return ResponseEntity.ok(updatedBus);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public List<Bus> getBuses(String source, String destination, String date) {
        return busDao.findBusesByRouteAndDay(source, destination, date);
    }
}
