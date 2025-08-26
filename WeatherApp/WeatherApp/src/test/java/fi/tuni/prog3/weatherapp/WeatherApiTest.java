
package fi.tuni.prog3.weatherapp;

import fi.tuni.prog3.weatherapp.config.WeatherApp;
import fi.tuni.prog3.weatherapp.dto.favoritedtos.FavoriteDto;
import fi.tuni.prog3.weatherapp.dto.weatherdtos.WeatherInfoDto;
import fi.tuni.prog3.weatherapp.entity.HistoryEntity;
import fi.tuni.prog3.weatherapp.repository.FavoriteRepository;
import fi.tuni.prog3.weatherapp.repository.HistoryRepository;
import fi.tuni.prog3.weatherapp.service.impl.FavoriteServiceImpl;
import fi.tuni.prog3.weatherapp.service.impl.WeatherServiceImpl;
import fi.tuni.prog3.weatherapp.templatemethoddesign.WeatherApiCall;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.isNull;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = WeatherApp.class)
@AutoConfigureMockMvc
public class WeatherApiTest {
    @Mock
    private WeatherApiCall weatherApi;
    @Mock
    private FavoriteRepository favoriteRepository;

    @Mock
    private HistoryRepository historyRepository;
    @InjectMocks
    private WeatherServiceImpl weatherService;

    @InjectMocks
    private FavoriteServiceImpl favoriteService;

    @Test
    public void testLookUpLocation_NotFound() {
        String location = "UnknownLocation";

        when(weatherApi.getWeatherByLocation(location)).thenThrow(WebClientResponseException.NotFound.class);

        WeatherInfoDto result = weatherService.lookUpLocation(location);

        assertNull(result);
    }

    @Test
    public void testGetCurrentWeather_DefaultLocation() {
        WeatherInfoDto defaultWeatherInfoDto = new WeatherInfoDto();

        when(weatherApi.getWeatherByLocation("Vaasa")).thenReturn(defaultWeatherInfoDto);

        WeatherInfoDto result = weatherService.lookUpLocation("Vaasa");
        assertNotNull(result);
        assertEquals(defaultWeatherInfoDto, result);
    }


    @Test
    public void lookUpLocation_Success() {
        final Long userId = 1L;
        final String cityName = "CityName";

        HistoryEntity mockHistoryEntity = new HistoryEntity();
        mockHistoryEntity.setId(1L);
        mockHistoryEntity.setUserId(userId);
        mockHistoryEntity.setCityName(cityName);

        when(historyRepository.searchHistory(eq(userId), eq(cityName), isNull(), isNull()))
                .thenReturn(Collections.singletonList(mockHistoryEntity));

        List<HistoryEntity> result = historyRepository.searchHistory(userId, cityName, null, null);

        assertNotNull(result, "Result list should not be null");
        assertFalse(result.isEmpty(), "Result list should not be empty");

        assertAll("HistoryEntity Properties",
                () -> assertEquals(1, result.size(), "Should return exactly one history entry"),
                () -> assertEquals(userId, result.get(0).getUserId(), "User ID should match"),
                () -> assertEquals(cityName, result.get(0).getCityName(), "City name should match")
        );

        verify(historyRepository, times(1)).searchHistory(eq(userId), eq(cityName), isNull(), isNull());
    }

    @Test
    public void lookUpLocation_LocationNotFound() {
        when(weatherApi.getWeatherByLocation(anyString())).thenThrow(WebClientResponseException.NotFound.class);
        WeatherInfoDto result = weatherService.lookUpLocation("NonExistentLocation");
        assertNull(result);
        verify(weatherApi, times(1)).getWeatherByLocation("NonExistentLocation");
        verify(historyRepository, never()).save(any(HistoryEntity.class));
    }

    @Test
    public void getListHistory_NoHistory_ReturnsEmptyList() {
        final Long userId = 1L;
        final String cityName = "NonExistentCity";

        when(historyRepository.searchHistory(eq(userId), eq(cityName), isNull(), isNull()))
                .thenReturn(Collections.emptyList());

        List<HistoryEntity> result = historyRepository.searchHistory(userId, cityName, null, null);

        assertNotNull(result, "Result list should not be null");
        assertTrue(result.isEmpty(), "Result list should be empty when no history is found");

        verify(historyRepository, times(1)).searchHistory(eq(userId), eq(cityName), isNull(), isNull());
    }

    @Test
    public void getListFavorite_EmptyList_ReturnsEmptyList() {
        Long userId = 1L;
        String cityName = "Tampere";

        when(favoriteRepository.findAllById(userId)).thenReturn(Collections.emptyList());

        List<FavoriteDto> result = favoriteService.getFavorite(userId);

        assertNotNull(result, "The result should not be null.");
        assertTrue(result.isEmpty(), "The result should be an empty list.");

        verify(favoriteRepository, times(1)).findAllById(userId);

    }

}