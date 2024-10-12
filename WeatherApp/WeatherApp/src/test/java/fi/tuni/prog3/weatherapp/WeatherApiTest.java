/**
package fi.tuni.prog3.weatherapp;

import fi.tuni.prog3.weatherapp.config.WeatherApp;
import fi.tuni.prog3.weatherapp.dto.weatherdtos.WeatherInfoDto;

import fi.tuni.prog3.weatherapp.service.WeatherServiceImpl;
import fi.tuni.prog3.weatherapp.weatherapi.WeatherApi;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = WeatherApp.class)
@AutoConfigureMockMvc
public class WeatherApiTest {
    @Mock
    private WeatherApi weatherApi;

    private WeatherServiceImpl weatherService;

    // Initialize mocks
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        weatherService = new WeatherServiceImpl(weatherApi);
    }

    @Test
    public void testLookUpLocation_NotFound() {
        // Arrange
        String location = "UnknownLocation";
        when(weatherApi.weatherInfo(location)).thenThrow(WebClientResponseException.NotFound.class);
        // Act
        WeatherInfoDto result = weatherService.lookUpLocation(location);
        // Assert
        assertNull(result);
    }

    @Test
    public void testGetCurrentWeather_DefaultLocation() {
        // Arrange
        WeatherInfoDto defaultWeatherInfoDto = new WeatherInfoDto();
        when(weatherApi.weatherInfo("Tampere")).thenReturn(defaultWeatherInfoDto);
        // Act
        WeatherInfoDto result = weatherService.getCurrentWeather(null);
        // Assert
        assertNotNull(result);
        assertEquals(defaultWeatherInfoDto, result);
    }


    @Test
    public void lookUpLocation_Success() {
        // Arrange
        WeatherInfoDto mockWeatherInfoDto = new WeatherInfoDto();
        mockWeatherInfoDto.setName("TestLocation");

        when(weatherApi.weatherInfo(anyString())).thenReturn(mockWeatherInfoDto);

        // Act
        WeatherInfoDto result = weatherService.lookUpLocation("TestLocation");
        // Assert
        assertNotNull(result);
        assertEquals("TestLocation", result.getName());
        // Verify interactions with mocks
        verify(weatherApi, times(1)).weatherInfo("TestLocation");

    }

    @Test
    public void lookUpLocation_LocationNotFound() {
        // Arrange
        when(weatherApi.weatherInfo(anyString())).thenThrow(WebClientResponseException.NotFound.class);
        // Act
        WeatherInfoDto result = weatherService.lookUpLocation("NonExistentLocation");
        // Assert
        assertNull(result);
        // Verify
        verify(weatherApi, times(1)).weatherInfo("NonExistentLocation");

    }

}*/