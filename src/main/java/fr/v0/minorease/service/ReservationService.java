package fr.v0.minorease.service;

import fr.v0.minorease.entity.Reservation;
import fr.v0.minorease.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getReservationsByUserId(Long parentId) {
        return reservationRepository.findByParentId(parentId);
    }

}