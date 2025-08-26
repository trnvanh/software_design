package fi.tuni.prog3.weatherapp.dto.weatherdtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ForecastDto {

    private Long dt;

    private MainDto main;

    private List<WeatherDto> weather;

    private CloudDto clouds;

    private WindDto wind;

    private Long visibility;

    private double pop;

    private SysDto sys;


    @JsonProperty("dt_txt")
    private String dtText;

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