package fr.v0.minorease.service;

import fr.v0.minorease.entity.Hotel;

import fr.v0.minorease.entity.Room;
import fr.v0.minorease.repository.HotelRepository;
import jakarta.persistence.PersistenceContext;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }
}

