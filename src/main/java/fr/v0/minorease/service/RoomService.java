package fr.v0.minorease.service;

import fr.v0.minorease.entity.Room;
import fr.v0.minorease.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }


    public List<Room> searchRooms(String city, Integer capacity, LocalDate arrivalDate, LocalDate departureDate, Double minRating, BigDecimal maxPrice) {
        return roomRepository.searchRooms(city, capacity, arrivalDate, departureDate, minRating, maxPrice);
    }

    public List<Room> getRoomsByHotelId(Long hotelId) {
        return roomRepository.findByHotelId(hotelId);
    }
}
