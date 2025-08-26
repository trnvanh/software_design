package fi.tuni.prog3.weatherapp.service.impl;

import fi.tuni.prog3.weatherapp.dto.weatherdtos.ForeCastInfoDto;
import fi.tuni.prog3.weatherapp.service.ForecastService;
import fi.tuni.prog3.weatherapp.templatemethoddesign.ForeCastApiCall;
import org.springframework.stereotype.Service;

@Service
public class ForecastServiceImpl implements ForecastService {

    private final ForeCastApiCall foreCastApiCall;

    public ForecastServiceImpl(ForeCastApiCall foreCastApiCall) {
        this.foreCastApiCall = foreCastApiCall;
    }

    @Override
    public ForeCastInfoDto getForecast(String location) {
        return foreCastApiCall.getForeCastByLocation(location);
    }
}
