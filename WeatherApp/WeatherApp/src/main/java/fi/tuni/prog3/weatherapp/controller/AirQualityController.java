package fi.tuni.prog3.weatherapp.controller;

import fi.tuni.prog3.weatherapp.service.AirServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AirQualityController {

    private final AirServiceTest airQualityService;

    @Autowired
    public AirQualityController(AirServiceTest airQualityService) {
        this.airQualityService = airQualityService;
    }

    @GetMapping("/air-quality")
    public String getAirQuality(@RequestParam String city) {
        airQualityService.fetchAndPrintAirQuality(city);
        return "Air quality data for " + city + " printed to console.";
    }
}
