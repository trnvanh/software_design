package fi.tuni.prog3.weatherapp.dto.historydtos;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import java.time.LocalDate;

public class HistoryDto {
    private Long id;
    private String weatherInfo;
    private Long userId;
    private String cityName;
    private Double temperature;
    private LocalDate createdDate;

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWeatherInfo() {
        return weatherInfo;
    }

    public void setWeatherInfo(String weatherInfo) {
        this.weatherInfo = weatherInfo;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }
}
