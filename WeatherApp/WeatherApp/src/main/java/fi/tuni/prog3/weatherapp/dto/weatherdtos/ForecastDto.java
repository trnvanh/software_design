package fi.tuni.prog3.weatherapp.dto.weatherdtos;

import java.util.List;

public class ForecastDto {

    private Long dt; // Time of forecast

    private MainDto main; // Main weather information

    private List<WeatherDto> weather; // Weather condition information

    private CloudDto clouds; // Cloud data

    private WindDto wind; // Wind data

    private Long visibility; // Visibility in meters

    private double pop; // Probability of precipitation

    private SysDto sys; // Additional system information

    private String dtText; // Date and time in text format

    public Long getDt() {
        return dt;
    }

    public void setDt(Long dt) {
        this.dt = dt;
    }

    public MainDto getMain() {
        return main;
    }

    public void setMain(MainDto main) {
        this.main = main;
    }

    public List<WeatherDto> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherDto> weather) {
        this.weather = weather;
    }

    public CloudDto getClouds() {
        return clouds;
    }

    public void setClouds(CloudDto clouds) {
        this.clouds = clouds;
    }

    public WindDto getWind() {
        return wind;
    }

    public void setWind(WindDto wind) {
        this.wind = wind;
    }

    public Long getVisibility() {
        return visibility;
    }

    public void setVisibility(Long visibility) {
        this.visibility = visibility;
    }

    public double getPop() {
        return pop;
    }

    public void setPop(double pop) {
        this.pop = pop;
    }

    public SysDto getSys() {
        return sys;
    }

    public void setSys(SysDto sys) {
        this.sys = sys;
    }

    public String getDtText() {
        return dtText;
    }

    public void setDtText(String dtText) {
        this.dtText = dtText;
    }
}