package fi.tuni.prog3.weatherapp.exception;

public class ClientErrorException extends RuntimeException {
        public ClientErrorException(String message) {
            super(message);
        }
    }