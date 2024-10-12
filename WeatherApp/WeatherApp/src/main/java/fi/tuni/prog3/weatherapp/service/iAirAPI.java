package fi.tuni.prog3.weatherapp.service;

import fi.tuni.prog3.weatherapp.dto.airdtos.AirDataDto;
import fi.tuni.prog3.weatherapp.dto.airdtos.AirForecastDto;
import fi.tuni.prog3.weatherapp.dto.airdtos.ResponseDto;
import fi.tuni.prog3.weatherapp.dto.weatherdtos.ForecastDto;

public interface iAirAPI {
    AirDataDto lookUpLocation(String loc);

    ResponseDto getCurrentAirData(String location);

    AirForecastDto getAirForecast(String location);
}
