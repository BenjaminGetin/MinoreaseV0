package fr.v0.minorease.repository;

import fr.v0.minorease.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
