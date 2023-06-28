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


    @GetMapping("/hotel/{id}")
    public ModelAndView showRoomsDetails(@PathVariable("id") Long hotelId) {
        ModelAndView modelAndView = new ModelAndView("hotel");
        Hotel hotels = hotelService.getHotelById(hotelId);
        List<Room> rooms = roomService.getRoomsByHotelId(hotelId);

        modelAndView.addObject("hotels", hotels);
        modelAndView.addObject("rooms", rooms);

        return modelAndView;
    }



}
