package fi.tuni.prog3.weatherapp.controller.support;

import fi.tuni.prog3.weatherapp.builderpattern.SearchHistory;
import fi.tuni.prog3.weatherapp.dto.historydtos.HistoryDto;
import fi.tuni.prog3.weatherapp.dto.userdtos.UserDto;
import fi.tuni.prog3.weatherapp.dto.weatherdtos.ForeCastInfoDto;
import fi.tuni.prog3.weatherapp.dto.weatherdtos.ForecastDto;
import fi.tuni.prog3.weatherapp.dto.weatherdtos.WeatherInfoDto;
import fi.tuni.prog3.weatherapp.service.impl.HistoryServiceImpl;
import fi.tuni.prog3.weatherapp.util.DateTimeUtil;
import fi.tuni.prog3.weatherapp.util.GsonUtils;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static fi.tuni.prog3.weatherapp.util.DateTimeUtil.formatLocalDateTime;

@Component
public class WeatherDisplaySupport {
    public static final String OPEN_WEATHER_URL_IMG = "https://openweathermap.org/img/wn/";

    @Autowired
    private HistoryServiceImpl historyService;

    public void updateCurrentWeather(WeatherInfoDto weatherInfoDto,
                                     Label temp_id, Label temp_description_id,
                                     Label sun_rise_id, Label sun_set_id,
                                     Label wind1, Label humidity1,
                                     Label highLow1, Label visibility1, Label pressure1, Label cloud1,
                                     Label aqi, Label main_pollutant, Label time1, Label feels_like1) {

        temp_id.setText(Math.round(weatherInfoDto.getMain().getTemp()) + "°C");
        temp_description_id.setText(weatherInfoDto.getWeather().get(0).getDescription().toUpperCase());
        sun_rise_id.setText(DateTimeUtil.convertToTimeString(weatherInfoDto.getSys().getSunrise()));
        sun_set_id.setText(DateTimeUtil.convertToTimeString(weatherInfoDto.getSys().getSunset()));
        wind1.setText(weatherInfoDto.getWind().getWindSpeed() + " m/s");
        humidity1.setText(weatherInfoDto.getMain().getHumidity() + "%");
        highLow1.setText(formatTemperatureRange(weatherInfoDto));
        visibility1.setText(weatherInfoDto.getVisibility() / 1000f + " km");
        pressure1.setText(weatherInfoDto.getMain().getPressure() + " mb");
        cloud1.setText(weatherInfoDto.getClouds().getCloudPercentage() + "%");
        aqi.setText(String.valueOf(weatherInfoDto.getAirQualityInfo().getData().getCurrent().getPollution().getAqius()));
        main_pollutant.setText(weatherInfoDto.getAirQualityInfo().getData().getCurrent().getPollution().getMainus());
        time1.setText("UTC " + DateTimeUtil.convertToTimeString(weatherInfoDto.getTimezone()));
        feels_like1.setText("Feels like " + weatherInfoDto.getMain().getFeelsLike() + "°C");
    }

    public void updateWeeklyForecast(ForeCastInfoDto forecastInfoDto,
                                     Label dateForecast1, Label dateForecast2, Label dateForecast3, Label dateForecast4,
                                     Label dateForecast5, Label highLowForecast1, Label highLowForecast2,
                                     Label highLowForecast3, Label highLowForecast4, Label highLowForecast5,
                                     Label statForecast1, Label statForecast2, Label statForecast3, Label statForecast4,
                                     Label statForecast5, ImageView iconForecast1, ImageView iconForecast2,
                                     ImageView iconForecast3, ImageView iconForecast4, ImageView iconForecast5) {

        Label[] dateForecasts = {dateForecast1, dateForecast2, dateForecast3, dateForecast4, dateForecast5};
        Label[] statForecasts = {statForecast1, statForecast2, statForecast3, statForecast4, statForecast5};
        Label[] highLowForecasts = {highLowForecast1, highLowForecast2, highLowForecast3, highLowForecast4, highLowForecast5};
        ImageView[] iconForecasts = {iconForecast1, iconForecast2, iconForecast3, iconForecast4, iconForecast5};

        for (int i = 0; i < 5; i++) {
            ForecastDto forecastDto = forecastInfoDto.getList().get(7 + i * 8);

            statForecasts[i].setText(forecastDto.getWeather().get(0).getMain());

            String temperatureRange = String.format("%d°C/%d°C",
                    Math.round(forecastDto.getMain().getTempMax()),
                    Math.round(forecastDto.getMain().getTempMin()));
            highLowForecasts[i].setText(temperatureRange);

            iconForecasts[i].setImage(new Image(OPEN_WEATHER_URL_IMG + forecastDto.getWeather().get(0).getIcon() + "@2x.png"));
        }
    }

    public XYChart.Series<String, Double> createTemperatureSeries(ForeCastInfoDto forecastInfoDto) {
        XYChart.Series<String, Double> series = new XYChart.Series<>();
        series.setName("Temperature");

        List<ForecastDto> forecastList = forecastInfoDto.getList();

        for (int i = 0; i < 5; i++) {
            ForecastDto forecastDto = forecastList.get(7 + i * 8);
            String date = formatLocalDateTime(forecastDto.getDtText()).split(" ")[0];
            double temperature = forecastDto.getMain().getTemp();

            series.getData().add(new XYChart.Data<>(date, temperature));
        }

        return series;
    }


    public XYChart.Series<String, Double> createTemperatureHumidity(ForeCastInfoDto forecastInfoDto) {
        XYChart.Series<String, Double> series = new XYChart.Series<>();
        series.setName("Humidity");

        List<ForecastDto> forecastList = forecastInfoDto.getList();

        for (int i = 0; i < 5; i++) {
            ForecastDto forecastDto = forecastList.get(7 + i * 8);
            String date = formatLocalDateTime(forecastDto.getDtText()).split(" ")[0];
            double temperature = forecastDto.getMain().getHumidity();

            series.getData().add(new XYChart.Data<>(date, temperature));
        }

        return series;
    }

    public XYChart.Series<String, Double> createTemperaturePrecipitation(ForeCastInfoDto forecastInfoDto) {
        XYChart.Series<String, Double> series = new XYChart.Series<>();
        series.setName("Precipitation");

        List<ForecastDto> forecastList = forecastInfoDto.getList();

        for (int i = 0; i < 5; i++) {
            ForecastDto forecastDto = forecastList.get(7 + i * 8);
            String date = formatLocalDateTime(forecastDto.getDtText()).split(" ")[0];
            double precipitation = forecastDto.getPop();

            series.getData().add(new XYChart.Data<>(date, precipitation));
        }

        return series;
    }

    private String formatTemperatureRange(WeatherInfoDto weatherInfoDto) {
        return weatherInfoDto.getMain().getTempMin() + "/" + weatherInfoDto.getMain().getTempMax();
    }

    public XYChart.Series<String, Double> createAqiSeries(UserDto userDto, String cityName) {
        XYChart.Series<String, Double> series = new XYChart.Series<>();
        series.setName("AQI");

        SearchHistory searchCriteria = new SearchHistory.SearchBuilder(userDto.getId())
                .withCityName(cityName)
                .build();

        List<HistoryDto> historyDtoList = historyService.getHistory(searchCriteria);

        if (historyDtoList == null || historyDtoList.isEmpty()) {
            return series;
        }

        for (HistoryDto historyDto : historyDtoList) {
            WeatherInfoDto weatherInfoHistory = GsonUtils.stringToObject(historyDto.getWeatherInfo(), WeatherInfoDto.class);
            LocalDate dateTime = historyDto.getCreatedDate();

            String formattedDate = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            Double airAqi = (double) weatherInfoHistory.getAirQualityInfo().getData().getCurrent().getPollution().getAqius();

            series.getData().add(new XYChart.Data<>(formattedDate, airAqi));
        }

        return series;
    }

}
