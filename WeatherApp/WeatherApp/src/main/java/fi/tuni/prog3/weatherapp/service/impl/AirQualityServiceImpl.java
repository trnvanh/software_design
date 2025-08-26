package fi.tuni.prog3.weatherapp.service.impl;

import fi.tuni.prog3.weatherapp.dto.airdtos.AirQualityInfoDto;
import fi.tuni.prog3.weatherapp.dto.airdtos.PollutionDto;
import fi.tuni.prog3.weatherapp.service.AirQualityService;
import fi.tuni.prog3.weatherapp.templatemethoddesign.AirApiCall;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AirQualityServiceImpl implements AirQualityService {

    private final AirApiCall airApiCall;

    public AirQualityServiceImpl(AirApiCall airApiCall) {
        this.airApiCall = airApiCall;
    }

    @Override
    public AirQualityInfoDto getAirQualityInfoBaseOnLonAndLat(Double lon, Double lat) {
        return airApiCall.getAirQualityByCoordinates(lat, lon);
    }

    @Override
    public List<PollutionDto> getForecastData(Double lon, Double lat) {
        return List.of();
    }
}
