package fi.tuni.prog3.weatherapp.dto.weatherdtos;

import java.util.List;


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

    public LocationDto getCoord() {
        return coord;
    }

    public void setCoord(LocationDto coord) {
        this.coord = coord;
    }

    public Long getTimezone() {
        return timezone;
    }

    public void setTimezone(Long timezone) {
        this.timezone = timezone;
    }

    public Long getDt() {
        return dt;
    }

    public void setDt(Long dt) {
        this.dt = dt;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public List<WeatherDto> getWeatherDtoList() {
        return weatherDtoList;
    }

    public void setWeatherDtoList(List<WeatherDto> weatherDtoList) {
        this.weatherDtoList = weatherDtoList;
    }

    public WeatherDto getMainWeather() {
        return mainWeather;
    }

    public void setMainWeather(WeatherDto mainWeather) {
        this.mainWeather = mainWeather;
    }

    public Long getVisibility() {
        return visibility;
    }

    public void setVisibility(Long visibility) {
        this.visibility = visibility;
    }

    public WindDto getWind() {
        return wind;
    }

    public void setWind(WindDto wind) {
        this.wind = wind;
    }

    public CloudDto getCloudPercentage() {
        return cloudPercentage;
    }

    public void setCloudPercentage(CloudDto cloudPercentage) {
        this.cloudPercentage = cloudPercentage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getSunrise() {
        return sunrise;
    }

    public void setSunrise(Long sunrise) {
        this.sunrise = sunrise;
    }

    public Long getSunset() {
        return sunset;
    }

    public void setSunset(Long sunset) {
        this.sunset = sunset;
    }
}
