package com.mujicaservices.course.reservationservices.repository;

import com.mujicaservices.course.reservationservices.domain.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    Optional<Iterable<Reservation>> findAllByDate();
}
