package fi.tuni.prog3.weatherapp.exception;

public class WeatherDataNotFoundException extends RuntimeException {
    public WeatherDataNotFoundException(String message) {
        super(message);
    }
}
