//package fi.tuni.prog3.weatherapp;
//
//import fi.tuni.prog3.weatherapp.config.WeatherApp;
//import javafx.application.Application;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
//
//@SpringBootApplication
//@EnableJpaAuditing
//public class WeatherSystemApplication {
//   public static void main(String[] args) {
//        Application.launch(WeatherApp.class, args);
//    }
//
//}

package fi.tuni.prog3.weatherapp;

import fi.tuni.prog3.weatherapp.service.AirServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherSystemApplication implements CommandLineRunner {

    private final AirServiceTest airQualityService;

    @Autowired
    public WeatherSystemApplication(AirServiceTest airQualityService) {
        this.airQualityService = airQualityService;
    }

    public static void main(String[] args) {
        SpringApplication.run(WeatherSystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        airQualityService.fetchAndPrintAirQuality("Eilat");
        airQualityService.fetchAndPrintAirQuality("Helsinki");
    }
}

