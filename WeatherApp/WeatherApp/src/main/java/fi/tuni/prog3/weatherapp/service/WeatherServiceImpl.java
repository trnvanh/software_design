package fi.tuni.prog3.weatherapp.service;

import fi.tuni.prog3.weatherapp.dto.weatherdtos.ForecastInfoDto;
import fi.tuni.prog3.weatherapp.dto.weatherdtos.WeatherInfoDto;

//import fi.tuni.prog3.weatherapp.util.GsonUtils;
import fi.tuni.prog3.weatherapp.weatherapi.WeatherApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
public class WeatherServiceImpl implements iWeatherAPI {
    private static final Logger logger = LoggerFactory.getLogger(WeatherServiceImpl.class);
    private static final String DEFAULT_LOCATION = "Tampere";
    private final WeatherApi weatherApi;

    public WeatherServiceImpl(WeatherApi weatherApi) {
        this.weatherApi = weatherApi;
    }

    @Override
    public WeatherInfoDto lookUpLocation(String loc) {
        return null;
    }

    @Override
    public WeatherInfoDto getCurrentWeather(String location) {
        if (location == null || location.equals("")) {
            return weatherApi.weatherInfo(DEFAULT_LOCATION);
        }
        return weatherApi.weatherInfo(location);
    }

    @Override
    public ForecastInfoDto getForecast(String location) {
        try {
            if (location == null || location.equals("")) {
                return weatherApi.foreCastInfo(DEFAULT_LOCATION);
            }
            return weatherApi.foreCastInfo(location);
        } catch (WebClientResponseException.NotFound notFoundException) {
            logger.error("Forecast Location not found: {}", location);
            return null;
        }
    }

}
