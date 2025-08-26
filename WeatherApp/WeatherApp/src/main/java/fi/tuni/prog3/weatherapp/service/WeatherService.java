package fi.tuni.prog3.weatherapp.service;

import fi.tuni.prog3.weatherapp.dto.weatherdtos.WeatherInfoDto;

/**
 * Open/Closed Principle
 * WeatherService class should be open for extension but closed for modification.
 */
public interface WeatherService {
    WeatherInfoDto lookUpLocation(String loc);

}