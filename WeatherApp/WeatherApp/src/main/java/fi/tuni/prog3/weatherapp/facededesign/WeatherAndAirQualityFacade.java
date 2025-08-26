package fi.tuni.prog3.weatherapp.facededesign;

import fi.tuni.prog3.weatherapp.dto.userdtos.UserDto;
import fi.tuni.prog3.weatherapp.dto.weatherdtos.WeatherInfoDto;

public interface WeatherAndAirQualityFacade {
    WeatherInfoDto getWeatherAndAirQuality(String location);

    WeatherInfoDto getWeatherAndAirQuality(String location, UserDto userDto);
}
