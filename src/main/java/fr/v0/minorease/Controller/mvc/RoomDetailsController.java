package fr.v0.minorease.Controller.mvc;

import fr.v0.minorease.entity.Hotel;
import fr.v0.minorease.entity.Room;
import fr.v0.minorease.service.HotelService;
import fr.v0.minorease.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RoomDetailsController {

    private final HotelService hotelService;
    private final RoomService roomService;

    public RoomDetailsController(HotelService hotelService, RoomService roomService) {
        this.hotelService = hotelService;
        this.roomService = roomService;
    }

    @GetMapping("/room/{id}")
    public ModelAndView showRoomDetails(@PathVariable("id") Long roomId) {
        ModelAndView modelAndView = new ModelAndView("hotel");
        Room room = roomService.getRoomById(roomId);
        Hotel hotel = room.getHotel();

        modelAndView.addObject("hotel", hotel);
        modelAndView.addObject("room", room);

        return modelAndView;
    }

    @GetMapping("/room/reservation/{id}")
    public String showReservation(@PathVariable("id") Long roomId, Model model) {
        Room room = roomService.getRoomById(roomId);

        model.addAttribute("room", room);

        return "reservation";
    }
}

