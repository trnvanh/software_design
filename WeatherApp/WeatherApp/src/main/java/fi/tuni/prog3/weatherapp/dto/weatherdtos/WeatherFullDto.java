package fi.tuni.prog3.weatherapp.dto.weatherdtos;

import java.util.List;

/**
 *
 */
public class WeatherFullDto {
    private LocationDto coord;

    private Long timezone;

    private Long dt;

    private String base;

    private List<WeatherDto> weatherDtoList;

    private WeatherDto mainWeather;

    private Long visibility;

    private WindDto wind;

    private CloudDto cloudPercentage;

    private Long id;

    private String cityName;

    private Long sunrise;

    private Long sunset;

    public void setCloudPercentage(CloudDto cloudPercentage) {
        this.cloudPercentage = cloudPercentage;
    }

    public void setVisibility(Long visibility) {
        this.visibility = visibility;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<WeatherDto> getWeatherDtoList() {
        return weatherDtoList;
    }

    public CloudDto getCloudPercentage() {
        return cloudPercentage;
    }

    public LocationDto getCoord() {
        return coord;
    }

    public Long getDt() {
        return dt;
    }

    public Long getId() {
        return id;
    }

    public Long getSunrise() {
        return sunrise;
    }

    public Long getSunset() {
        return sunset;
    }

    public Long getTimezone() {
        return timezone;
    }

    public Long getVisibility() {
        return visibility;
    }

    public String getCityName() {
        return cityName;
    }

    public WeatherDto getMainWeather() {
        return mainWeather;
    }

    public WindDto getWind() {
        return wind;
    }

    public String getBase() {
        return base;
    }

    public void setCoord(LocationDto coord) {
        this.coord = coord;
    }

    public void setDt(Long dt) {
        this.dt = dt;
    }

    public void setMain_weather(WeatherDto mainWeather) {
        this.mainWeather = mainWeather;
    }

    public void setSunrise(Long sunrise) {
        this.sunrise = sunrise;
    }

    public void setSunset(Long sunset) {
        this.sunset = sunset;
    }

    public void setWeatherDtoList(List<WeatherDto> weatherDtoList) {
        this.weatherDtoList = weatherDtoList;
    }

    public void setTimezone(Long timezone) {
        this.timezone = timezone;
    }

    public void setWind(WindDto wind) {
        this.wind = wind;
    }
}
