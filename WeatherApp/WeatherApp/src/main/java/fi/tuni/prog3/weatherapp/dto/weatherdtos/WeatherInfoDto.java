package fi.tuni.prog3.weatherapp.dto.weatherdtos;

import fi.tuni.prog3.weatherapp.dto.airdtos.AirQualityInfoDto;

import java.util.List;


public class WeatherInfoDto {
    private LocationDto coord;
    private List<WeatherDto> weather;
    private String base;
    private MainDto main;
    private Long visibility;
    private WindDto wind;
    private CloudDto clouds;
    private Long dt;
    private SysDto sys;
    private Long timezone;
    private Long id;
    private String name;
    private Long cod;
    private AirQualityInfoDto airQualityInfo;
    private ForeCastInfoDto foreCastInfoDto;

    public LocationDto getCoord() {
        return coord;
    }

    public void setCoord(LocationDto coord) {
        this.coord = coord;
    }

    public List<WeatherDto> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherDto> weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public MainDto getMain() {
        return main;
    }

    public void setMain(MainDto main) {
        this.main = main;
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

    public CloudDto getClouds() {
        return clouds;
    }

    public void setClouds(CloudDto clouds) {
        this.clouds = clouds;
    }

    public Long getDt() {
        return dt;
    }

    public void setDt(Long dt) {
        this.dt = dt;
    }

    public SysDto getSys() {
        return sys;
    }

    public void setSys(SysDto sys) {
        this.sys = sys;
    }

    public Long getTimezone() {
        return timezone;
    }

    public void setTimezone(Long timezone) {
        this.timezone = timezone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCod() {
        return cod;
    }

    public void setCod(Long cod) {
        this.cod = cod;
    }

    public AirQualityInfoDto getAirQualityInfo() {
        return airQualityInfo;
    }

    public void setAirQualityInfo(AirQualityInfoDto airQualityInfo) {
        this.airQualityInfo = airQualityInfo;
    }

    public ForeCastInfoDto getForeCastInfoDto() {
        return foreCastInfoDto;
    }

    public void setForeCastInfoDto(ForeCastInfoDto foreCastInfoDto) {
        this.foreCastInfoDto = foreCastInfoDto;
    }
}
