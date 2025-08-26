package fi.tuni.prog3.weatherapp.controller;

import fi.tuni.prog3.weatherapp.facededesign.WeatherAndAirQualityFacade;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import lombok.Getter;
import net.rgielen.fxweaver.core.FxmlView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
@FxmlView("/HomeLayout.fxml")
public class HomeController implements Initializable {

    private static final Logger log = LoggerFactory.getLogger(HistoryController.class);
    @FXML
    @Getter
    private TextField inputSearch;

    private final DataTransferController dataTransferController = DataTransferController.getInstance();
    private final WeatherAndAirQualityFacade weatherAndAirQualityFacade;

    public HomeController(WeatherAndAirQualityFacade weatherAndAirQualityFacade) {
        this.weatherAndAirQualityFacade = weatherAndAirQualityFacade;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (dataTransferController.getDataInput() != null) {
            log.info("data search found");
            inputSearch.setText(dataTransferController.getDataInput());
            enableDataAndCurrentButtons();
        } else {
            log.info("data search not found");
            disableDataAndCurrentButtons();
        }
    }

    @FXML
    void search(ActionEvent event) {
        var searchInput = inputSearch.getText();
        if (searchInput == null || searchInput.trim().isEmpty()) {
            showAlert("Input Error", "Please enter a city name.");
        } else {
            var userDto = dataTransferController.getUserDto();
            if (userDto == null) {
                showAlert("Error", "User not logged in.");
                return;
            }

            var weatherInfoDto = weatherAndAirQualityFacade.getWeatherAndAirQuality(searchInput, userDto);
            if (weatherInfoDto != null) {
                dataTransferController.setDataInput(searchInput);
                dataTransferController.setWeatherInfoDto(weatherInfoDto);
                dataTransferController.loadLayout(CurrentController.class);
                enableDataAndCurrentButtons();
            } else {
                showAlert("Location Error", "Location not found: " + searchInput);
                disableDataAndCurrentButtons();
            }
        }
    }

    public void handleEnterPressed(KeyEvent event) throws Exception {
        if (event.getCode() == KeyCode.ENTER) {
            search(new ActionEvent());
        }
    }

    @FXML
    private void enableDataAndCurrentButtons() {
        dataTransferController.getBtnData().setDisable(false);
        dataTransferController.getBtnCurrent().setDisable(false);
    }

    @FXML
    private void disableDataAndCurrentButtons() {
        dataTransferController.getBtnData().setDisable(true);
        dataTransferController.getBtnCurrent().setDisable(true);
    }

    private void showAlert(String title, String message) {
        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(title);
            alert.setHeaderText(null);
            alert.setContentText(message);
            alert.showAndWait();
        });
    }
}