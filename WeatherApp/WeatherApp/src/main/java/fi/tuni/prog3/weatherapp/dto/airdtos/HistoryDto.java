package fi.tuni.prog3.weatherapp.dto.airdtos;

import java.util.ArrayList;
import java.util.List;


public class HistoryDto {
    private List<WeatherDto> weather;
    private List<PollutionDto> pollution = new ArrayList<>();

    public List<WeatherDto> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherDto> weather) {
        this.weather = weather;
    }

    public List<PollutionDto> getPollution() {
        return pollution;
    }

    public void setPollution(List<PollutionDto> pollution) {
        this.pollution = pollution;
    }
}
