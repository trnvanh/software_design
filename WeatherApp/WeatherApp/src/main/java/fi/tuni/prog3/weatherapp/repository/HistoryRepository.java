package fi.tuni.prog3.weatherapp.repository;

import fi.tuni.prog3.weatherapp.entity.HistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HistoryRepository extends JpaRepository<HistoryEntity, Long> {

    @Query(value = "SELECT *\n" +
            "FROM history h\n" +
            "WHERE h.user_id = :userId\n" +
            "  AND (:cityName IS NULL OR LOWER(h.city_name) LIKE CONCAT('%', LOWER(:cityName), '%'))\n" +
            "  AND (:fromDate IS NULL OR h.created_date >= CAST(:fromDate AS DATE))\n" +
            "  AND (:toDate IS NULL OR h.created_date <= CAST(:toDate AS DATE))",
            nativeQuery = true)
    List<HistoryEntity> searchHistory(
            @Param("userId") Long userId,
            @Param("cityName") String cityName,
            @Param("fromDate") String fromDate,
            @Param("toDate") String toDate
    );
}