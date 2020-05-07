package com.mujicaservices.course.reservationservices.controller;

import com.mujicaservices.course.reservationservices.domain.Reservation;
import com.mujicaservices.course.reservationservices.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/reservations")
public class ReservationController {
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public Iterable<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{reservationId}", produces = "application/json")
    public Reservation getById(@PathVariable(name = "reservationId") long reservationId){
        return reservationRepository.findById(reservationId)
                .orElseThrow(() -> new NoSuchElementException("Reservation is not in the system"));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{date}", produces = "application/json")
    public Iterable<Reservation> getByDate(@PathVariable(name = "date")Date date){
        return reservationRepository.findAllByDate()
                .orElseThrow(()-> new NoSuchElementException("No reservations were found for date " + date.toString()));
    }
}
