package fi.tuni.prog3.weatherapp.service;

import fi.tuni.prog3.weatherapp.dto.favoritedtos.FavoriteDto;
import fi.tuni.prog3.weatherapp.dto.weatherdtos.WeatherInfoDto;

import java.util.List;

public interface FavoriteService {
    List<FavoriteDto> getFavorite(Long userId);

    void toggleFavorite(WeatherInfoDto weatherInfoDto, Long userId);

    boolean deleteFavorite(WeatherInfoDto weatherInfoDto, Long userId);

    Boolean isSavedFavorite(WeatherInfoDto weatherInfoDto, Long userId);
}
