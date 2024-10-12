package fi.tuni.prog3.weatherapp.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
@FxmlView("/ForecastLayout.fxml")
public class ForecastController {
    @FXML
    private ImageView btn_add_favorite, headerIcon;

    @FXML
    private ImageView iconForecast1, iconForecast2, iconForecast3, iconForecast4, iconForecast5;

    @FXML
    private Label current_id, current_location, headerStat, headerStatDesc, headerTemp, highLow, humidity, moonP, pressure, time, uv, visibility, wind;

    @FXML
    private Label dateForecast1, dateForecast2, dateForecast3, dateForecast4, dateForecast5;

    @FXML
    private Label highLowForecast1, highLowForecast2, highLowForecast3, highLowForecast4, highLowForecast5;

    @FXML
    private Label statForecast1, statForecast2, statForecast3, statForecast4, statForecast5;

    @FXML
    void addFavorite(MouseEvent event) {

    }
}

