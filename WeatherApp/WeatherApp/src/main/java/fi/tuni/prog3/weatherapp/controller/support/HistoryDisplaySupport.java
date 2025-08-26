package fi.tuni.prog3.weatherapp.controller.support;

import fi.tuni.prog3.weatherapp.dto.historydtos.HistoryDto;
import fi.tuni.prog3.weatherapp.dto.weatherdtos.WeatherInfoDto;
import fi.tuni.prog3.weatherapp.util.DateTimeUtil;
import fi.tuni.prog3.weatherapp.util.GsonUtils;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.round;

@Slf4j
public class HistoryDisplaySupport {

    public void displayHistoryTable(List<HistoryDto> historyDtoList, TableView<HistoryDto> historyResultTable,
                                     TableColumn<HistoryDto, String> idColumn, TableColumn<HistoryDto, String> cityNameColumn,
                                     TableColumn<HistoryDto, String> dateColumn, TableColumn<HistoryDto, String> tempColumn) {
        historyResultTable.getItems().clear();

        List<WeatherInfoDto> weatherInfoDtos = new ArrayList<>();
        for (HistoryDto historyDto : historyDtoList) {
            String weatherInfoDto = historyDto.getWeatherInfo();
            WeatherInfoDto weatherInfo = GsonUtils.stringToObject(weatherInfoDto, WeatherInfoDto.class);
            weatherInfoDtos.add(weatherInfo);
        }

        idColumn.setCellValueFactory(data -> new SimpleStringProperty(String.valueOf(((HistoryDto) data.getValue()).getId())));
        cityNameColumn.setCellValueFactory(data -> new SimpleStringProperty(((HistoryDto) data.getValue()).getCityName()));

        dateColumn.setCellValueFactory(data -> {
            HistoryDto historyDto = (HistoryDto) data.getValue();
            WeatherInfoDto weatherInfo = GsonUtils.stringToObject(historyDto.getWeatherInfo(), WeatherInfoDto.class);
            return new SimpleStringProperty(DateTimeUtil.convertTimestampToLocalDateTime(weatherInfo.getDt()));
        });

        tempColumn.setCellValueFactory(data -> {
            HistoryDto historyDto = (HistoryDto) data.getValue();
            WeatherInfoDto weatherInfo = GsonUtils.stringToObject(historyDto.getWeatherInfo(), WeatherInfoDto.class);
            return new SimpleStringProperty(String.valueOf(round(weatherInfo.getMain().getTemp())));
        });

        // Set data in table
        ObservableList<HistoryDto> observableList = FXCollections.observableArrayList(historyDtoList);
        historyResultTable.setItems(observableList);
    }
}
