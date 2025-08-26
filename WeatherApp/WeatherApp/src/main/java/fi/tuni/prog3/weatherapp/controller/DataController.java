package fi.tuni.prog3.weatherapp.controller;

import fi.tuni.prog3.weatherapp.builderpattern.SearchHistory;
import fi.tuni.prog3.weatherapp.controller.support.WeatherDisplaySupport;
import fi.tuni.prog3.weatherapp.dto.airdtos.AirQualityInfoDto;
import fi.tuni.prog3.weatherapp.dto.historydtos.HistoryDto;
import fi.tuni.prog3.weatherapp.dto.userdtos.UserDto;
import fi.tuni.prog3.weatherapp.dto.weatherdtos.ForeCastInfoDto;
import fi.tuni.prog3.weatherapp.dto.weatherdtos.WeatherInfoDto;
import fi.tuni.prog3.weatherapp.facededesign.WeatherAndAirQualityFacade;
import fi.tuni.prog3.weatherapp.service.HistoryService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import net.rgielen.fxweaver.core.FxmlView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

@FxmlView("/DataLayout.fxml")
@Component
public class DataController implements Initializable {
    private static final Logger log = LoggerFactory.getLogger(DataController.class);

    @FXML
    public Button weatherBtn, airQualityBtn, searchAirDataBtn, searchWeatherDataBtn;

    @FXML
    public Label locationCity;

    @FXML
    private LineChart<String, Double> lineChart;

    @FXML
    private Label dateForecast1, dateForecast2, dateForecast3, dateForecast4, dateForecast5;

    @FXML
    private Label highLowForecast1, highLowForecast2, highLowForecast3, highLowForecast4, highLowForecast5;

    @FXML
    private Label statForecast1, statForecast2, statForecast3, statForecast4, statForecast5;

    @FXML
    private ImageView iconForecast1, iconForecast2, iconForecast3, iconForecast4, iconForecast5;

    @FXML
    private CheckBox temperatureCheckbox, humidityCheckbox, precipitationCheckbox;

    @FXML
    private DatePicker fromDateData, toDateData;

    private final DataTransferController dataTransferController = DataTransferController.getInstance();
    private final WeatherDisplaySupport weatherDisplaySupport;
    private final WeatherAndAirQualityFacade weatherAndAirQualityFacade;
    private ForeCastInfoDto foreCastInfoDto;
    private AirQualityInfoDto airQualityInfoDto;

    @Autowired
    private HistoryService historyService;

    public DataController(WeatherDisplaySupport weatherDisplaySupport, WeatherAndAirQualityFacade weatherAndAirQualityFacade, ForeCastInfoDto foreCastInfoDto) {
        this.weatherDisplaySupport = weatherDisplaySupport;
        this.weatherAndAirQualityFacade = weatherAndAirQualityFacade;
        this.foreCastInfoDto = foreCastInfoDto;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        var weatherInfoDto = dataTransferController.getWeatherInfoDto();

        locationCity.setText(weatherInfoDto.getName());
        temperatureCheckbox.setSelected(true);
        fromDateData.setDisable(true);
        toDateData.setDisable(true);
        searchWeatherDataBtn.setDisable(true);
        searchAirDataBtn.setDisable(true);
        lineChart.getData().add(weatherDisplaySupport.createTemperatureSeries(weatherInfoDto.getForeCastInfoDto()));

        temperatureCheckbox.setOnAction(event -> updateGraphSelected(weatherInfoDto));
        humidityCheckbox.setOnAction(event -> updateGraphSelected(weatherInfoDto));
        precipitationCheckbox.setOnAction(event -> updateGraphSelected(weatherInfoDto));

        weatherDisplaySupport.updateWeeklyForecast(
                weatherInfoDto.getForeCastInfoDto(), dateForecast1, dateForecast2, dateForecast3,
                dateForecast4, dateForecast5, highLowForecast1, highLowForecast2,
                highLowForecast3, highLowForecast4, highLowForecast5, statForecast1,
                statForecast2, statForecast3, statForecast4, statForecast5, iconForecast1,
                iconForecast2, iconForecast3, iconForecast4, iconForecast5
        );

        setActiveButton(weatherBtn);
    }

    @FXML
    private void updateGraphSelected(WeatherInfoDto weatherInfoDto) {
        lineChart.getData().clear();

        if (temperatureCheckbox.isSelected()) {
            XYChart.Series<String, Double> temperatureSeries = weatherDisplaySupport
                    .createTemperatureSeries(weatherInfoDto.getForeCastInfoDto());
            lineChart.getData().add(temperatureSeries);
        }

        if (humidityCheckbox.isSelected()) {
            XYChart.Series<String, Double> humiditySeries = weatherDisplaySupport
                    .createTemperatureHumidity(weatherInfoDto.getForeCastInfoDto());
            lineChart.getData().add(humiditySeries);
        }

        if (precipitationCheckbox.isSelected()) {
            XYChart.Series<String, Double> precipitationSeries = weatherDisplaySupport
                    .createTemperaturePrecipitation(weatherInfoDto.getForeCastInfoDto());
            lineChart.getData().add(precipitationSeries);
        }
    }

    @FXML
    private void selectWeather() {
        setActiveButton(weatherBtn);
        humidityCheckbox.setVisible(true);
        temperatureCheckbox.setVisible(true);
        precipitationCheckbox.setVisible(true);
        fromDateData.setDisable(true);
        toDateData.setDisable(true);
        searchWeatherDataBtn.setDisable(true);
        searchAirDataBtn.setDisable(true);
        var weatherInfoDto = dataTransferController.getWeatherInfoDto();
        lineChart.getData().clear();
        lineChart.getData().add(weatherDisplaySupport.createTemperatureSeries(weatherInfoDto.getForeCastInfoDto()));
        updateGraphSelected(weatherInfoDto);
    }

    @FXML
    private void searchWeather() {
        lineChart.getData().clear();
        humidityCheckbox.setVisible(true);
        temperatureCheckbox.setVisible(true);
        precipitationCheckbox.setVisible(true);

    }

    @FXML
    private void selectAirQuality() {
        setActiveButton(airQualityBtn);
        var weatherInfoDto = dataTransferController.getWeatherInfoDto();
        UserDto userDto = dataTransferController.getUserDto();
        lineChart.getData().clear();
        humidityCheckbox.setVisible(false);
        temperatureCheckbox.setVisible(false);
        precipitationCheckbox.setVisible(false);
        searchAirDataBtn.setDisable(false);
        searchWeatherDataBtn.setDisable(true);
        fromDateData.setDisable(false);
        toDateData.setDisable(false);
        XYChart.Series<String, Double> series = weatherDisplaySupport.createAqiSeries(userDto, weatherInfoDto.getName());

        lineChart.getData().add(series);
    }

    @FXML
    private void updateAirGraph(List<HistoryDto> historyDtoList, LocalDate fromDate, LocalDate toDate) {

    }

    @FXML
    private void searchAirQuality() {
        lineChart.getData().clear();
        humidityCheckbox.setVisible(false);
        temperatureCheckbox.setVisible(false);
        precipitationCheckbox.setVisible(false);

        LocalDate fromDate = fromDateData.getValue();
        LocalDate toDate = toDateData.getValue();

        String cityName = dataTransferController.getDataInput();
        UserDto userDto = dataTransferController.getUserDto();
        Long userId = userDto.getId();

        SearchHistory searchCriteria = new SearchHistory.SearchBuilder(userId)
                .withCityName(cityName)
                .withFromDate(fromDate)
                .withToDate(toDate)
                .build();
        List<HistoryDto> historyDtoList = historyService.getHistory(searchCriteria);

        updateAirGraph(historyDtoList, fromDate, toDate);

    }


    private void setActiveButton(Button button) {
        if (weatherBtn != null) weatherBtn.setStyle("-fx-background-color: #7AB2B2; -fx-text-fill: white;");
        if (airQualityBtn != null) airQualityBtn.setStyle("-fx-background-color: #7AB2B2; -fx-text-fill: white;");
        button.setStyle("-fx-background-color: #4a6969; -fx-text-fill: white;");
    }
}
