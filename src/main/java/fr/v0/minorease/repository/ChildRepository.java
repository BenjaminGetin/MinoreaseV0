package fr.v0.minorease.repository;

import fr.v0.minorease.entity.Child;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildRepository extends JpaRepository<Child, Long> {
}
