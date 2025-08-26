package fi.tuni.prog3.weatherapp.exception;

public class ServerErrorException extends RuntimeException {
    public ServerErrorException(String message) {
        super(message);
    }
}