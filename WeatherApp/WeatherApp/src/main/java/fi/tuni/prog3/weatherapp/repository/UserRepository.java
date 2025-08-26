package fi.tuni.prog3.weatherapp.repository;

import fi.tuni.prog3.weatherapp.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsernameAndPassword(String username, String password);
}
