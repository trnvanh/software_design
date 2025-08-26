package fi.tuni.prog3.weatherapp.service.impl;

import fi.tuni.prog3.weatherapp.dto.favoritedtos.FavoriteDto;
import fi.tuni.prog3.weatherapp.dto.weatherdtos.WeatherInfoDto;
import fi.tuni.prog3.weatherapp.entity.FavoriteEntity;
import fi.tuni.prog3.weatherapp.repository.FavoriteRepository;
import fi.tuni.prog3.weatherapp.service.FavoriteService;
import fi.tuni.prog3.weatherapp.util.Converter;
import fi.tuni.prog3.weatherapp.util.GsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavoriteServiceImpl implements FavoriteService {
    private static final Logger log = LoggerFactory.getLogger(FavoriteServiceImpl.class);
    private final FavoriteRepository favoriteRepository;

    public FavoriteServiceImpl(final FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }

    @Override
    public List<FavoriteDto> getFavorite(final Long userId) {
        var favoriteEntities = favoriteRepository.findAllById(userId);
        return favoriteEntities.stream()
                .map(entity -> enrichWithWeatherInfo(Converter.toModel(entity, FavoriteDto.class)))
                .collect(Collectors.toList());
    }

    @Override
    public void toggleFavorite(final WeatherInfoDto weatherInfoDto, final Long userId) {
        var existingFavorite = favoriteRepository.findByUserIdAndCityName(userId, weatherInfoDto.getName());

        if (existingFavorite.isPresent()) {
            favoriteRepository.delete(existingFavorite.get());
            log.info("City '{}' removed from favorites", weatherInfoDto.getName());
        } else {
            saveNewFavorite(weatherInfoDto, userId);
        }
    }

    @Override
    public boolean deleteFavorite(final WeatherInfoDto weatherInfoDto, final Long userId) {
        return favoriteRepository.findByUserIdAndCityName(userId, weatherInfoDto.getName())
                .map(favorite -> {
                    favoriteRepository.delete(favorite);
                    log.info("City '{}' deleted successfully", weatherInfoDto.getName());
                    return true;
                })
                .orElseGet(() -> {
                    log.warn("City '{}' not found for deletion", weatherInfoDto.getName());
                    return false;
                });
    }

    @Override
    public Boolean isSavedFavorite(final WeatherInfoDto weatherInfoDto, final Long userId) {
        return favoriteRepository.findByUserIdAndCityName(userId, weatherInfoDto.getName()).isPresent();
    }

    private FavoriteDto enrichWithWeatherInfo(final FavoriteDto favoriteDto) {
        var weatherInfoDto = GsonUtils.stringToObject(favoriteDto.getWeatherInfo(), WeatherInfoDto.class);
        favoriteDto.setWeatherInfoDto(weatherInfoDto);
        return favoriteDto;
    }

    private void saveNewFavorite(final WeatherInfoDto weatherInfoDto, final Long userId) {
        var favoriteEntity = new FavoriteEntity();
        favoriteEntity.setUserId(userId);
        favoriteEntity.setCityName(weatherInfoDto.getName());
        favoriteEntity.setWeatherInfo(GsonUtils.objectToString(weatherInfoDto));
        favoriteRepository.save(favoriteEntity);
        log.info("City '{}' added to favorites", weatherInfoDto.getName());
    }
}
