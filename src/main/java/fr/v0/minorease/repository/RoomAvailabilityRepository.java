package fr.v0.minorease.repository;

import fr.v0.minorease.entity.Reservation;
import fr.v0.minorease.entity.RoomAvailability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomAvailabilityRepository extends JpaRepository<RoomAvailability, Long> {
}
