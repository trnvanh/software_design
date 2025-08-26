package fi.tuni.prog3.weatherapp.service.impl;

import fi.tuni.prog3.weatherapp.builderpattern.SearchHistory;
import fi.tuni.prog3.weatherapp.dto.historydtos.HistoryDto;
import fi.tuni.prog3.weatherapp.dto.weatherdtos.WeatherInfoDto;
import fi.tuni.prog3.weatherapp.entity.HistoryEntity;
import fi.tuni.prog3.weatherapp.repository.HistoryRepository;
import fi.tuni.prog3.weatherapp.service.HistoryService;
import fi.tuni.prog3.weatherapp.util.Converter;
import fi.tuni.prog3.weatherapp.util.GsonUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {

    private final HistoryRepository historyRepository;

    public HistoryServiceImpl(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Override
    public List<HistoryDto> getHistory(final SearchHistory searchHistory) {
        var cityName = searchHistory.getCityName() == null || searchHistory.getCityName().trim().isEmpty()
                ? null
                : searchHistory.getCityName();

        var fromDate = searchHistory.getFromDate() == null ? null : String.valueOf(searchHistory.getFromDate());
        var toDate = searchHistory.getToDate() == null ? null : String.valueOf(searchHistory.getToDate());

        var historyEntities = historyRepository.searchHistory(
                searchHistory.getUserId(),
                cityName,
                fromDate,
                toDate
        );
        var historyDtoList = Converter.toList(historyEntities, HistoryDto.class);

        historyDtoList.forEach(historyDto -> {
            WeatherInfoDto weatherInfoDto = GsonUtils.stringToObject(historyDto.getWeatherInfo(), WeatherInfoDto.class);
            if (weatherInfoDto != null && weatherInfoDto.getMain() != null) {
                historyDto.setTemperature(weatherInfoDto.getMain().getTemp());
            }
        });
        return historyDtoList;
    }

    @Override
    public void saveHistory(final WeatherInfoDto weatherInfoDto, final Long userId) {
        var historyEntity = new HistoryEntity();
        historyEntity.setWeatherInfo(GsonUtils.objectToString(weatherInfoDto));
        historyEntity.setUserId(userId);
        historyEntity.setCityName(weatherInfoDto.getName());
        historyRepository.save(historyEntity);
    }
}
