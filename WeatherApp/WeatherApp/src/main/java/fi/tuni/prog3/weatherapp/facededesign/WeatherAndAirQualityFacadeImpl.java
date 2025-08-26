package fi.tuni.prog3.weatherapp.facededesign;

import fi.tuni.prog3.weatherapp.dto.userdtos.UserDto;
import fi.tuni.prog3.weatherapp.dto.weatherdtos.WeatherInfoDto;
import fi.tuni.prog3.weatherapp.service.AirQualityService;
import fi.tuni.prog3.weatherapp.service.ForecastService;
import fi.tuni.prog3.weatherapp.service.HistoryService;
import fi.tuni.prog3.weatherapp.service.WeatherService;
import org.springframework.stereotype.Component;


/**
 * Facade Pattern
 * The facade pattern provides a simplified interface to a complex subsystem.
 * In application, if expose WeatherService and AirQualityService directly to clients (like controllers or other services),
 * clients would need to understand the details of both services to effectively use them.
 * The facade pattern decouples the client from the subsystems.
 * Clients do not need to be aware of the relationships between the WeatherService and AirQualityService, allowing them to function independently.
 * Using a facade can reduce the number of dependencies in your application. Instead of having clients directly depend on multiple services, they only depend on the facade.
 */

@Component
public class WeatherAndAirQualityFacadeImpl implements WeatherAndAirQualityFacade {
    private static final String defaultLocation = "Tampere";

    private final WeatherService weatherService;
    private final ForecastService forecastService;
    private final AirQualityService airQualityService;
    private final HistoryService historyService;

    public WeatherAndAirQualityFacadeImpl(WeatherService weatherService, ForecastService forecastService, AirQualityService airQualityService, HistoryService historyService) {
        this.weatherService = weatherService;
        this.forecastService = forecastService;
        this.airQualityService = airQualityService;
        this.historyService = historyService;
    }

    @Override
    public WeatherInfoDto getWeatherAndAirQuality(String location) {
        var weatherInfoDto = weatherService.lookUpLocation(location);

        if (weatherInfoDto == null) {
            weatherInfoDto = weatherService.lookUpLocation(defaultLocation);
        }

        var latitude = weatherInfoDto.getCoord().getLat();
        var longitude = weatherInfoDto.getCoord().getLon();

        var airQualityInfoDto = airQualityService.getAirQualityInfoBaseOnLonAndLat(longitude, latitude);
        var forecastInfoDto = forecastService.getForecast(location);

        weatherInfoDto.setAirQualityInfo(airQualityInfoDto);
        weatherInfoDto.setForeCastInfoDto(forecastInfoDto);

        return weatherInfoDto;
    }

    @Override
    public WeatherInfoDto getWeatherAndAirQuality(String location, UserDto userDto) {
        var weatherInfoDto = weatherService.lookUpLocation(location);

        if (weatherInfoDto == null) {
            return null;
        }

        var latitude = weatherInfoDto.getCoord().getLat();
        var longitude = weatherInfoDto.getCoord().getLon();

        var airQualityInfoDto = airQualityService.getAirQualityInfoBaseOnLonAndLat(longitude, latitude);
        var forecastInfoDto = forecastService.getForecast(location);

        weatherInfoDto.setAirQualityInfo(airQualityInfoDto);
        weatherInfoDto.setForeCastInfoDto(forecastInfoDto);

        historyService.saveHistory(weatherInfoDto, userDto.getId());
        return weatherInfoDto;
    }
}
