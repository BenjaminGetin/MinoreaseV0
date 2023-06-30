package fr.v0.minorease.repository;

import fr.v0.minorease.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByParentId(Long parentId);
}
