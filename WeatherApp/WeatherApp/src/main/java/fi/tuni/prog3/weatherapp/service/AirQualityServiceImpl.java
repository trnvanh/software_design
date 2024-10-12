package fi.tuni.prog3.weatherapp.service;

//import fi.tuni.prog3.weatherapp.util.GsonUtils;
import fi.tuni.prog3.weatherapp.airapi.AirApi;
import fi.tuni.prog3.weatherapp.dto.airdtos.AirDataDto;
import fi.tuni.prog3.weatherapp.dto.airdtos.ResponseDto;
import fi.tuni.prog3.weatherapp.dto.airdtos.AirForecastDto;
import fi.tuni.prog3.weatherapp.dto.weatherdtos.ForecastInfoDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
public class AirQualityServiceImpl implements iAirAPI {
    private static final Logger logger = LoggerFactory.getLogger(AirQualityServiceImpl.class);
    private static final String DEFAULT_LOCATION = "Tampere";
    private final AirApi airApi;

    public AirQualityServiceImpl(AirApi airApi) {
        this.airApi = airApi;
    }

    @Override
    public AirDataDto lookUpLocation(String loc) {
        return null;
    }

    @Override
    public ResponseDto getCurrentAirData (String location) {
        if (location == null || location.isEmpty()) {
            return airApi.getAirQualityInfo(DEFAULT_LOCATION);
        }
        return airApi.getAirQualityInfo(location);
    }

    @Override
    public AirForecastDto getAirForecast(String location) {
        try {
            if (location == null || location.isEmpty()) {
                return airApi.getForecastInfo(DEFAULT_LOCATION);
            }
            return airApi.getForecastInfo(location);
        } catch (WebClientResponseException.NotFound notFoundException) {
            logger.error("Forecast Location not found: {}", location);
            return null;
        }
    }

}
