package fi.tuni.prog3.weatherapp.repository;

import fi.tuni.prog3.weatherapp.entity.FavoriteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<FavoriteEntity, Long> {
    @Query(value = "SELECT * FROM favorite f WHERE f.user_id = :userId", nativeQuery = true)
    List<FavoriteEntity> findAllById(
            @Param("userId") Long userId
    );


    Optional<FavoriteEntity> findByUserIdAndCityName(Long userId, String cityName);



}
