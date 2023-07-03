package fr.v0.minorease.Controller.mvc;

import fr.v0.minorease.entity.Reservation;
import fr.v0.minorease.repository.ReservationRepository;
import fr.v0.minorease.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ReservationUserController {

    private final ReservationService reservationService;
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationUserController(ReservationService reservationService, ReservationRepository reservationRepository) {
        this.reservationService = reservationService;
        this.reservationRepository = reservationRepository;
    }

    @GetMapping("/reservation")
    public String getUserReservations(Model model) {
        List<Reservation> reservations = reservationRepository.findAll();
        model.addAttribute("reservations", reservations);
        model.addAttribute("activePage", "reservation"); // Ajoutez cette ligne
        return "reservation-list";
    }


    @GetMapping("/reservation/{id}")
    public String getReservationById(@PathVariable("id") Long id, Model model) {
        Reservation reservation = reservationRepository.findById(id).orElse(null);
        model.addAttribute("reservation", reservation);
        return "reservation-details";
    }
}
