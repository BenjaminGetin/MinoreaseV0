package fr.v0.minorease.Controller.mvc;

import fr.v0.minorease.entity.Reservation;
import fr.v0.minorease.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ReservationuserController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationuserController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/reservation/{id}")
    public String getUserReservations(@PathVariable("id") Long parentId, Model model) {
        // Récupérer les réservations pour l'utilisateur spécifié par l'ID
        List<Reservation> reservations = reservationService.getReservationsByUserId(parentId);

        // Ajouter les réservations au modèle pour les afficher dans la vue
        model.addAttribute("reservations", reservations);

        // Retourner le nom de la vue Thymeleaf
        return "reservation-list";
    }
}
