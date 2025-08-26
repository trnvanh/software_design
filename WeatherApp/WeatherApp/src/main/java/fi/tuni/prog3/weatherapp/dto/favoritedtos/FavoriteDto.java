package fi.tuni.prog3.weatherapp.dto.favoritedtos;

import fi.tuni.prog3.weatherapp.dto.weatherdtos.WeatherInfoDto;


public class FavoriteDto {
    private Long id;
    private String weatherInfo;
    private Long userId;
    private String cityName;
    private Double temperature;
    private WeatherInfoDto weatherInfoDto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWeatherInfo() {
        return weatherInfo;
    }

    public void setWeatherInfo(String weatherInfo) {
        this.weatherInfo = weatherInfo;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public WeatherInfoDto getWeatherInfoDto() {
        return weatherInfoDto;
    }

    public void setWeatherInfoDto(WeatherInfoDto weatherInfoDto) {
        this.weatherInfoDto = weatherInfoDto;
    }
}
