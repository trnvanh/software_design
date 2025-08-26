package fi.tuni.prog3.weatherapp.service;

import fi.tuni.prog3.weatherapp.dto.weatherdtos.ForeCastInfoDto;

public interface ForecastService {
    ForeCastInfoDto getForecast(String location);
}
