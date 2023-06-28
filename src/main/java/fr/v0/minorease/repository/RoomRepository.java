package fr.v0.minorease.repository;

import fr.v0.minorease.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    @Query("SELECT DISTINCT r FROM Hotel h JOIN h.rooms r JOIN r.availabilities a WHERE h.city LIKE %:city% AND r.capacity >= :capacity AND NOT EXISTS (SELECT 1 FROM RoomAvailability a2 WHERE a2.room = r AND a2.date BETWEEN :arrivalDate AND :departureDate) AND h.rating >= :minRating AND r.price >= :maxPrice")
    List<Room> searchRooms(@Param("city") String city, @Param("capacity") Integer capacity, @Param("arrivalDate") LocalDate arrivalDate, @Param("departureDate") LocalDate departureDate, @Param("minRating") Double minRating, @Param("maxPrice") BigDecimal maxPrice);

}
