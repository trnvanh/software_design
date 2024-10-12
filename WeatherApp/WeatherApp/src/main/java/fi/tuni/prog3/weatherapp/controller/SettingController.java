package fi.tuni.prog3.weatherapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import org.springframework.stereotype.Component;

@Component
public class SettingController {
    @FXML
    private ComboBox<?> activitiesComboBox;

    @FXML
    private Button btnSave;

    @FXML
    private DatePicker fromDatePicker;

    @FXML
    private DatePicker toDatePicker;

    @FXML
    void save(ActionEvent event) {

    }
}
