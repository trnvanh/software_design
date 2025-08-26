package fi.tuni.prog3.weatherapp.dto.airdtos;


import java.util.List;


public class AirDataDto {
    private String city;
    private String state;
    private String country;
    private LocationDto location;
    private List<AirForecastDto> forecasts;
    private CurrentDataDto current;
    private HistoryDto history;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocationDto getLocation() {
        return location;
    }

    public void setLocation(LocationDto location) {
        this.location = location;
    }

    public List<AirForecastDto> getForecasts() {
        return forecasts;
    }

    public void setForecasts(List<AirForecastDto> forecasts) {
        this.forecasts = forecasts;
    }

    public CurrentDataDto getCurrent() {
        return current;
    }

    public void setCurrent(CurrentDataDto current) {
        this.current = current;
    }

    public HistoryDto getHistory() {
        return history;
    }

    public void setHistory(HistoryDto history) {
        this.history = history;
    }
}
