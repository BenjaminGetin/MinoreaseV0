package fr.v0.minorease.Controller.mvc;

import fr.v0.minorease.entity.Room;
import fr.v0.minorease.service.RoomService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Controller
public class IndexController {

    private final RoomService roomService;

    public IndexController(RoomService roomService) {
        this.roomService = roomService;
    }


    @GetMapping("/index")
    public String searchRooms(Model model, @RequestParam(value = "city", required = false) String city, @RequestParam(value = "capacity", required = false) Integer capacity, @RequestParam(value = "arrivalDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate arrivalDate, @RequestParam(value = "departureDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate departureDate, @RequestParam(value = "minRating", required = false) Double minRating, @RequestParam(value = "maxPrice", required = false) BigDecimal maxPrice) {
        List<Room> rooms = roomService.searchRooms(city, capacity, arrivalDate, departureDate, minRating, maxPrice);
        int totalRooms = rooms.size();

        model.addAttribute("rooms", rooms);
        model.addAttribute("totalRooms", totalRooms); // Ajouter le nombre total de résultats

        return "index";
    }






}
