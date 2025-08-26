package fi.tuni.prog3.weatherapp.service.impl;

import fi.tuni.prog3.weatherapp.dto.weatherdtos.WeatherInfoDto;
import fi.tuni.prog3.weatherapp.exception.ResourceNotFoundException;
import fi.tuni.prog3.weatherapp.service.WeatherService;
import fi.tuni.prog3.weatherapp.templatemethoddesign.WeatherApiCall;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


/**
 * Single Responsibility Principle
 * The WeatherServiceImpl class is responsible only for retrieving weather data and handling fallbacks
 * when the requested location isn't available. It doesn't handle UI, database logic, or other unrelated concerns.
 */

/**
 * Dependency Injection: Using constructor-based dependency injection (@RequiredArgsConstructor),
 * where the dependency (WeatherApiCall) is injected into the WeatherServiceImpl class.
 */
@Service
public class WeatherServiceImpl implements WeatherService {
    private static final Logger logger = LoggerFactory.getLogger(WeatherServiceImpl.class);
    private static final String DEFAULT_LOCATION = "Tampere";

    private final WeatherApiCall weatherApiCall;

    public WeatherServiceImpl(WeatherApiCall weatherApiCall) {
        this.weatherApiCall = weatherApiCall;
    }

    @Override
    public WeatherInfoDto lookUpLocation(final String location) {

        String queryLocation = (location == null || location.isBlank()) ? DEFAULT_LOCATION : location;

        logger.info("Looking up weather information for location: {}", queryLocation);

        try {
            WeatherInfoDto weatherInfoDto = weatherApiCall.getWeatherByLocation(queryLocation);
            logger.info("Successfully retrieved weather information for location: {}", queryLocation);
            return weatherInfoDto;
        } catch (ResourceNotFoundException e) {
            logger.warn("Location not found: '{}'", queryLocation);
            return null;
        } catch (Exception e) {
            logger.error("Error occurred while fetching weather data: {}", e.getMessage());
            return null;
        }
    }

}
