package fr.v0.minorease.repository;

import fr.v0.minorease.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query("SELECT DISTINCT r FROM Room r JOIN r.hotel h LEFT JOIN r.availabilities a WHERE " +
            "(:city IS NULL OR h.city LIKE %:city%) " +
            "AND (:capacity IS NULL OR r.capacity >= :capacity) " +
            "AND (:arrivalDate IS NULL OR :departureDate IS NULL OR NOT EXISTS (SELECT a2 FROM RoomAvailability a2 WHERE a2.room = r AND a2.date BETWEEN :arrivalDate AND :departureDate)) " +
            "AND (:minRating IS NULL OR h.rating >= :minRating) " +
            "AND (:maxPrice IS NULL OR r.price >= :maxPrice)")
    List<Room> searchRooms(@Param("city") String city, @Param("capacity") Integer capacity, @Param("arrivalDate") LocalDate arrivalDate, @Param("departureDate") LocalDate departureDate, @Param("minRating") Double minRating, @Param("maxPrice") BigDecimal maxPrice);

    List<Room> findByHotelId(Long hotelId);

}
