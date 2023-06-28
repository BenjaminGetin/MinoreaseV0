package fr.v0.minorease.Controller.api;

import fr.v0.minorease.entity.Room;
import fr.v0.minorease.service.RoomService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v0/room")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/search")
    public List<Room> searchRooms(@RequestParam(value = "city", required = false) String city, @RequestParam(value = "capacity", required = false) Integer capacity, @RequestParam(value = "arrivalDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate arrivalDate, @RequestParam(value = "departureDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate departureDate, @RequestParam(value = "minRating", required = false) Double minRating, @RequestParam(value = "maxPrice", required = false) BigDecimal maxPrice) {
        return roomService.searchRooms(city, capacity, arrivalDate, departureDate, minRating, maxPrice);
         }
         }
