package fi.tuni.prog3.weatherapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.springframework.stereotype.Component;

@Component
public class MenuController {
    @FXML
    private Button Forecast;

    @FXML
    private Button btnData;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnSetting;

    @FXML
    void goData(ActionEvent event) {
    }

    @FXML
    void goForecast(ActionEvent event) {
    }

    @FXML
    void goHome(ActionEvent event) {
    }

    @FXML
    void goSetting(ActionEvent event) {
    }


}
