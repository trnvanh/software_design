package fi.tuni.prog3.weatherapp.exception;

public class NetworkException extends RuntimeException {
    public NetworkException(String message) {
        super(message);
    }
}