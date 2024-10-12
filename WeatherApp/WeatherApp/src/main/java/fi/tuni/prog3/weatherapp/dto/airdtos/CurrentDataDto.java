package fi.tuni.prog3.weatherapp.dto.airdtos;

public class CurrentDataDto {
    private WeatherDto weather;
    private PollutionDto pollution;

    public PollutionDto getPollution() {
        return pollution;
    }

    public void setPollution(PollutionDto pollution) {
        this.pollution = pollution;
    }

    public void setWeather(WeatherDto weather) {
        this.weather = weather;
    }

    public WeatherDto getWeather() {
        return weather;
    }
}
