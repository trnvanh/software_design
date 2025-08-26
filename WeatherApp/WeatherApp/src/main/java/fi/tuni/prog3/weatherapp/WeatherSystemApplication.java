package fi.tuni.prog3.weatherapp;

import fi.tuni.prog3.weatherapp.config.WeatherApp;
import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(scanBasePackages = "fi.tuni.prog3.weatherapp")
@EnableJpaAuditing
public class WeatherSystemApplication {
    public static void main(String[] args) {
        Application.launch(WeatherApp.class, args);
    }
}
