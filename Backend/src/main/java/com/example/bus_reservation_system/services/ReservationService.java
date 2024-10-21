package com.example.bus_reservation_system.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.bus_reservation_system.entity.Reservation;
import com.example.bus_reservation_system.repositories.ReservationDao;

@Service
public class ReservationService {
    @Autowired
    ReservationDao reservationDao;

   public Reservation createTicket(@RequestBody Reservation res){
        return reservationDao.save(res);
    }
    public Optional<Reservation> getTicket(long id){
        return reservationDao.findById(id);
    }


    public List<Reservation> getAllReservations(){
        return reservationDao.findAll();
    }

    public Optional<Reservation> getAllTicket(Long busId){
        return reservationDao.findById(busId);
    }

    public ResponseEntity<Reservation> updateReservation(long id, Reservation reservation) {
        Optional<Reservation> existingReservationOpt = reservationDao.findById(id);

        if (existingReservationOpt.isPresent()) {
            Reservation existingReservation = existingReservationOpt.get();

            existingReservation.setUser_id(reservation.getUser_id());
            existingReservation.setBus_id(reservation.getBus_id());
            existingReservation.setReservationDate(reservation.getReservationDate());
            existingReservation.setSeatNumber(reservation.getSeatNumber());

            Reservation updatedReservation = reservationDao.save(existingReservation);
            return ResponseEntity.ok(updatedReservation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public void deleteTicket(long id){
        reservationDao.deleteById(id);
    }

//    public List<Reservation> getReservationsByUserIdAndBusId(Long userId, Long busId) {
//        return reservationDao.findReservationByUserIdAndBusId(userId,busId);
//    }
}