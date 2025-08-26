package fi.tuni.prog3.weatherapp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import fi.tuni.prog3.weatherapp.builderpattern.SearchHistory;
import fi.tuni.prog3.weatherapp.dto.historydtos.HistoryDto;
import fi.tuni.prog3.weatherapp.dto.userdtos.UserDto;
import fi.tuni.prog3.weatherapp.dto.weatherdtos.WeatherInfoDto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface HistoryService {
    List<HistoryDto> getHistory(SearchHistory searchHistory);
    void saveHistory(WeatherInfoDto weatherInfoDto, Long userId);
}
