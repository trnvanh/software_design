package fi.tuni.prog3.weatherapp.service;

import fi.tuni.prog3.weatherapp.dto.airdtos.AirQualityInfoDto;
import fi.tuni.prog3.weatherapp.dto.airdtos.PollutionDto;

import java.util.List;

public interface AirQualityService {
    AirQualityInfoDto getAirQualityInfoBaseOnLonAndLat(Double lon, Double lat);

    List<PollutionDto> getForecastData(Double lon, Double lat);
}
