package fi.tuni.prog3.weatherapp.dto.airdtos;

public class CurrentDataDto {
    private PollutionDto pollution;
    private WeatherDto weather;

    public PollutionDto getPollution() {
        return pollution;
    }

    public void setPollution(PollutionDto pollution) {
        this.pollution = pollution;
    }

    public WeatherDto getWeather() {
        return weather;
    }

    public void setWeather(WeatherDto weather) {
        this.weather = weather;
    }
}
