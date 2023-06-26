package fr.v0.minorease.repository;

import fr.v0.minorease.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
