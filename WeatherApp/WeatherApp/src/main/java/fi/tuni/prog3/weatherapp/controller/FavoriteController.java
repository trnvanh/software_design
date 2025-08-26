package fi.tuni.prog3.weatherapp.controller;

import fi.tuni.prog3.weatherapp.dto.favoritedtos.FavoriteDto;
import fi.tuni.prog3.weatherapp.dto.weatherdtos.WeatherInfoDto;
import fi.tuni.prog3.weatherapp.service.FavoriteService;
import fi.tuni.prog3.weatherapp.util.GsonUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import net.rgielen.fxweaver.core.FxmlView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static java.lang.Math.round;

@FxmlView("/FavoriteLayout.fxml")
@Component
public class FavoriteController implements Initializable {
    @FXML
    private VBox cityCardContainer;
    private static final Logger log = LoggerFactory.getLogger(FavoriteController.class);


    private final DataTransferController dataTransferController = DataTransferController.getInstance();
    private final FavoriteService favoriteService;

    @Autowired
    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        var userDto = dataTransferController.getUserDto();
        var userId = userDto.getId();
        log.info("Initializing favorites for user: {}", userId);

        var favoriteDtoList = favoriteService.getFavorite(userId);
        log.info("Fetched favorites: {}", favoriteDtoList);

        populateCityCards(favoriteDtoList);
    }

    @FXML
    public void populateCityCards(List<FavoriteDto> favoriteCities) {
        cityCardContainer.getChildren().clear();

        favoriteCities.forEach(city -> {
            log.info("Creating card for city: {}", city.getCityName());
            Pane cityCard = createCityCard(city);
            cityCardContainer.getChildren().add(cityCard);
        });
    }

    private Pane createCityCard(FavoriteDto favoriteDto) {
        Pane card = new Pane();
        card.setMaxSize(600, 100);
        card.setStyle("-fx-background-color: #f0f0f0; -fx-border-radius: 5; -fx-background-radius: 5;");

        HBox contentBox = new HBox(20);
        contentBox.setAlignment(Pos.CENTER_LEFT);
        contentBox.setPrefSize(400, 100);
        contentBox.setPadding(new javafx.geometry.Insets(10));
        contentBox.setStyle("-fx-border-width: 1; -fx-border-color: #e0e0e0;");

        VBox infoBox = createCityInfoBox(favoriteDto);
        HBox buttonBox = createButtonBox(favoriteDto);

        contentBox.getChildren().addAll(infoBox, buttonBox);
        HBox.setHgrow(buttonBox, javafx.scene.layout.Priority.ALWAYS);

        card.getChildren().add(contentBox);
        return card;
    }

    private VBox createCityInfoBox(FavoriteDto favoriteDto) {
        VBox infoBox = new VBox(5);

        Label cityName = new Label(favoriteDto.getCityName());
        cityName.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Label weatherInfo = new Label("Weather Info: " + round(favoriteDto.getWeatherInfoDto().getMain().getTemp()) + "°C, " + favoriteDto.getWeatherInfoDto().getWeather().get(0).getDescription());
        weatherInfo.setStyle("-fx-font-size: 12px; -fx-text-fill: #555;");

        Label airInfo = new Label("Air Info: AQI US " + favoriteDto.getWeatherInfoDto().getAirQualityInfo().getData().getCurrent().getPollution().getAqius());
        airInfo.setStyle("-fx-font-size: 12px; -fx-text-fill: #555;");

        infoBox.getChildren().addAll(cityName, weatherInfo, airInfo);
        return infoBox;
    }

    private HBox createButtonBox(FavoriteDto favoriteDto) {
        HBox buttonBox = new HBox(10);
        buttonBox.setStyle("-fx-alignment: center-right;");

        Button deleteButton = new Button("Delete");
        deleteButton.setStyle("-fx-background-color: #f44336; -fx-text-fill: white;");
        deleteButton.setOnAction(event -> deleteCity(favoriteDto));

        buttonBox.getChildren().add(deleteButton);
        return buttonBox;
    }

    private void deleteCity(FavoriteDto favoriteDto) {
        log.info("Attempting to delete city: {}", favoriteDto.getCityName());

        WeatherInfoDto weatherInfoDto = GsonUtils.stringToObject(favoriteDto.getWeatherInfo(), WeatherInfoDto.class);

        boolean isDeleted = favoriteService.deleteFavorite(weatherInfoDto, favoriteDto.getUserId());

        if (isDeleted) {
            List<FavoriteDto> favoriteCities = favoriteService.getFavorite(dataTransferController.getUserDto().getId());
            populateCityCards(favoriteCities);

            log.info("Successfully deleted city: {}", favoriteDto.getCityName());

            showAlert("Success", "City Deleted", "The city " + favoriteDto.getCityName() + " has been successfully deleted from your favorites.");
        } else {
            log.error("Failed to delete city: {}", favoriteDto.getCityName());

            showAlert("Error", "Deletion Failed", "Failed to delete the city " + favoriteDto.getCityName() + ". Please try again.");
        }
    }

    private void showAlert(String title, String headerText, String contentText) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
    }
}
