package fi.tuni.prog3.weatherapp.dto.airdtos;

import java.util.List;

public class AirDataDto {
    private String name;

    private String city;

    private String state;

    private String country;

    private LocationDto location;

    private List<AirForecastDto> forecasts;

    private CurrentDataDto current;

    private HistoryDto history;

    private UnitsDto units;

    public CurrentDataDto getCurrent() {
        return current;
    }

    public List<AirForecastDto> getForecasts() {
        return forecasts;
    }

    public HistoryDto getHistory() {
        return history;
    }

    public LocationDto getLocation() {
        return location;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public UnitsDto getUnits() {
        return units;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCurrent(CurrentDataDto current) {
        this.current = current;
    }

    public void setForecasts(List<AirForecastDto> forecasts) {
        this.forecasts = forecasts;
    }

    public void setHistory(HistoryDto history) {
        this.history = history;
    }

    public void setLocation(LocationDto location) {
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setUnits(UnitsDto units) {
        this.units = units;
    }
}
