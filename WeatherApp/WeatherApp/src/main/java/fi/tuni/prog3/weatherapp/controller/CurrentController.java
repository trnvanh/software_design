package fi.tuni.prog3.weatherapp.controller;

import fi.tuni.prog3.weatherapp.controller.support.WeatherDisplaySupport;
import fi.tuni.prog3.weatherapp.dto.airdtos.AirQualityInfoDto;
import fi.tuni.prog3.weatherapp.dto.airdtos.PollutionDto;
import fi.tuni.prog3.weatherapp.dto.userdtos.UserDto;
import fi.tuni.prog3.weatherapp.dto.weatherdtos.WeatherInfoDto;
import fi.tuni.prog3.weatherapp.facededesign.WeatherAndAirQualityFacade;
import fi.tuni.prog3.weatherapp.service.FavoriteService;
import fi.tuni.prog3.weatherapp.util.DateTimeUtil;
import fi.tuni.prog3.weatherapp.util.StringUtil;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import lombok.RequiredArgsConstructor;
import net.rgielen.fxweaver.core.FxmlView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;


@FxmlView("/CurrentLayout.fxml")
@Component
public class CurrentController implements Initializable {
    private static final Logger log = LoggerFactory.getLogger(CurrentController.class);

    private final DataTransferController dataTransferController = DataTransferController.getInstance();
    private final WeatherDisplaySupport weatherDisplaySupport;
    private final WeatherAndAirQualityFacade weatherAndAirQualityFacade;
    public Line needlePointer;
    public Rectangle aqiRectangle;
    public Label aqiRecLabel;
    public Text aqiLevelText;
    public Label aqiValue;

    public CurrentController(WeatherDisplaySupport weatherDisplaySupport, WeatherAndAirQualityFacade weatherAndAirQualityFacade) {
        this.weatherDisplaySupport = weatherDisplaySupport;
        this.weatherAndAirQualityFacade = weatherAndAirQualityFacade;
    }

    @Autowired
    private FavoriteService favoriteService;

    @FXML
    private Label timeDateLabel;
    @FXML
    private Label feels_like1, temp_id, highLow1, humidity1,
            sun_set_id, pressure1, time1, sun_rise_id, visibility1, wind1, cloud1, main_pollutant, aqi,
            temp_description_id, txt_city;
    @FXML
    public ImageView btn_add_favorite1;

    private WeatherInfoDto weatherInfoDto;

    @Override
    public void initialize(final URL url, final ResourceBundle resourceBundle) {
        UserDto userDto = getLoggedInUser();
        if (userDto == null) return;

        weatherInfoDto = dataTransferController.getWeatherInfoDto();
        if (weatherInfoDto == null) {
            String dataInput = dataTransferController.getDataInput();
            weatherInfoDto = weatherAndAirQualityFacade.getWeatherAndAirQuality(dataInput, userDto);
            dataTransferController.setWeatherInfoDto(weatherInfoDto);
        }

        if (weatherInfoDto != null) {
            updateUI(dataTransferController.getDataInput(), userDto);
            weatherInfoDto = weatherAndAirQualityFacade.getWeatherAndAirQuality(dataTransferController.getDataInput());

            PollutionDto currentPollution = weatherInfoDto.getAirQualityInfo().getData().getCurrent().getPollution();
            // update indicator
            setupAirQualityMeter(currentPollution.getAqius());
        } else {
            log.error("Weather information is not available.");
            displayErrorMessage("Unable to retrieve weather information. Please try again.");
        }
    }

    private void updateUI(final String dataInput, final UserDto userDto) {
        displayIcon(weatherInfoDto, userDto.getId());
        weatherDisplaySupport.updateCurrentWeather(weatherInfoDto, temp_id, temp_description_id,
                sun_rise_id, sun_set_id, wind1, humidity1,
                highLow1, visibility1, pressure1, cloud1, aqi, main_pollutant, time1, feels_like1);

        var cityName = StringUtil.capitalizeFirstLetter(dataInput);
        txt_city.setText(cityName);
        timeDateLabel.setText(DateTimeUtil.convertToTimeString(weatherInfoDto.getDt()));
    }

    private void displayIcon(WeatherInfoDto weatherInfoDto, Long userId) {
        String iconPath = favoriteService.isSavedFavorite(weatherInfoDto, userId)
                ? "/images/icon/added_favorite.png"
                : "/images/icon/add-to-favorites.png";

        btn_add_favorite1.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream(iconPath))));
    }

    @FXML
    void addFavorite(final MouseEvent event) {
        log.info("add/remove to favorite");
        var userDto = getLoggedInUser();
        if (userDto == null) {
            log.error("User is not logged in");
            displayErrorMessage("Please log in to add favorites.");
            return;
        }

        if (weatherInfoDto == null) {
            log.error("Weather information is not available");
            displayErrorMessage("Unable to add favorite. Weather information is not available.");
            return;
        }
        favoriteService.toggleFavorite(weatherInfoDto, userDto.getId());
        displayIcon(weatherInfoDto, userDto.getId());
    }

    private UserDto getLoggedInUser() {
        var userDto = dataTransferController.getUserDto();
        if (userDto == null) {
            log.error("User is not logged in.");
            displayErrorMessage("Please log in to view weather information.");
        }
        return userDto;
    }

    private void displayErrorMessage(final String message) {
        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText(message);
            alert.showAndWait();
        });
    }

    private void setupAirQualityMeter(double airQualityValue) {

        rotatePointer(needlePointer, airQualityValue);
        setAqiColor(airQualityValue);

        aqiValue.setText(String.valueOf((int)airQualityValue));
        aqiLevelText.setText(getAirQualityText(airQualityValue));
        aqiRecLabel.setWrapText(true);
        aqiRecLabel.setMaxWidth(500);
        aqiRecLabel.setText(getAqiRecText(airQualityValue));
    }


    private void setAqiColor(double value) {

        if (value <= 50) {
            aqiRectangle.setFill(Paint.valueOf("#c6fcbd"));
            aqiRectangle.setStroke(Paint.valueOf("#c6fcbd"));
        } else if (value <= 100) {
            aqiRectangle.setFill(Paint.valueOf("#fbfcbd"));
            aqiRectangle.setStroke(Paint.valueOf("#fbfcbd"));
        }else if (value <= 150) {
            aqiRectangle.setFill(Paint.valueOf("#fcd8bd"));
            aqiRectangle.setStroke(Paint.valueOf("#fcd8bd"));
        }else if (value <= 200) {
            aqiRectangle.setFill(Paint.valueOf("#fcbdbd"));
            aqiRectangle.setStroke(Paint.valueOf("#fcbdbd"));
        } else if (value <= 300) {
            aqiRectangle.setFill(Paint.valueOf("#c8bdfc"));
            aqiRectangle.setStroke(Paint.valueOf("#c8bdfc"));
        }else {
            aqiRectangle.setFill(Paint.valueOf("#f7bdfc"));
            aqiRectangle.setStroke(Paint.valueOf("#f7biff"));
        }
    }

    // Helper method to get air quality text based on value
    private String getAirQualityText(double value) {

        if (value <= 50) {
            return "Air quality is good";
        } else if (value <= 100) {
            return "Air quality is moderate";
        }else if (value <= 150) {
            return "Air quality is unhealthy for Sensitive Groups";
        }else if (value <= 200) {
            return "Air quality is unhealthy";
        } else if (value <= 300) {
            return "Air quality is very unhealthy";
        }else {
            return "Air quality is hazardous";
        }
    }

    // Helper method to get activity recommendation based on value
    private String getAqiRecText(double val) {
        int value = (int) val;
        if (value <= 50) {
            return "At AQI level " + value + " air quality is satisfactory and poses little or no risks.";
        } else if (value <= 100) {
            return "At AQI level " + value + " sensitive individuals should avoid outdoor activity as they may experience respiratory symptoms";
        }else if (value <= 150) {
            return "At AQI level " + value + " general public and sensitive individuals in particular are at risk to experience irritation and respiratory problems";
        }else if (value <= 200) {
            return "At AQI level " + value + " increased likelihood of adverse effects and aggravation to the heart and lungs among general public";
        } else if (value <= 300) {
            return "At AQI level " + value + " general public will be noticeably affected. Sensitive groups should restrict outdoor activities";
        }else {
            return "At AQI level " + value + " general public at high risk of experiencing strong irritations and adverse health effects. Should avoid outdoors.";
        }
    }

    // Helper method to rotate the pointer
    private void rotatePointer(Line pointer, double value) {

        // Define ranges and corresponding EndX and EndY values
        double[][] ranges = {
                {30, -121, 7},  // {Max Value, EndX, EndY}
                {50, -115, -13},
                {100, -91, -43},
                {150, -57, -57},
                {200, -21, -52},
                {300, 9, -30},
                {500, 25, 7},
                {Double.MAX_VALUE, -49, -57} // Default case
        };

        // Determine the correct EndX and EndY for the given value
        for (double[] range : ranges) {
            if (value <= range[0]) {
                pointer.setEndX(range[1]);
                pointer.setEndY(range[2]);
                break; // Exit the loop once the range is found
            }
        }
    }

}

