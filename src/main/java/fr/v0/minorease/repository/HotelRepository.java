package fr.v0.minorease.repository;

import fr.v0.minorease.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HotelRepository extends JpaRepository<Hotel, Long> {

}