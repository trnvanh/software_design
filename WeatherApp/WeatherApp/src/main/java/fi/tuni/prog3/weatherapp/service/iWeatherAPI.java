package fi.tuni.prog3.weatherapp.service;

import fi.tuni.prog3.weatherapp.dto.weatherdtos.ForecastInfoDto;
import fi.tuni.prog3.weatherapp.dto.weatherdtos.WeatherInfoDto;

public interface iWeatherAPI {
    WeatherInfoDto lookUpLocation(String loc);

    WeatherInfoDto getCurrentWeather(String location);

    ForecastInfoDto getForecast(String location);

}