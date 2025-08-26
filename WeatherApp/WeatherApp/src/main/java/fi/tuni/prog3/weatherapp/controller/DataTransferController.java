package fi.tuni.prog3.weatherapp.controller;

import fi.tuni.prog3.weatherapp.dto.userdtos.UserDto;
import fi.tuni.prog3.weatherapp.dto.weatherdtos.WeatherInfoDto;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import lombok.Getter;
import lombok.Setter;
import net.rgielen.fxweaver.core.FxWeaver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * The Singleton ensures that there's only one instance of the DataTransferController class across the application,
 * which is useful when managing shared resources such as UI components (buttons, layouts) or state (dataInput, fxWeaver).
 * We are using Lazy Initialization: The instance is created only when it is needed, which is referred to as "lazy initialization".
 * The instance is not created when the application starts but only when getInstance() is first called.
 */

@Component
public class DataTransferController {
    private static final Logger log = LoggerFactory.getLogger(DataTransferController.class);
    private static DataTransferController instance;
    private String dataInput;
    private AnchorPane content;
    private Button btnCurrent;
    private Button btnData;
    private Button btnHome;
    private Button btnFavorite;
    private Button btnHistory;
    private Button btnAccount;
    private FxWeaver fxWeaver;
    private final Map<Class<?>, Button> controllerButtonMap = new HashMap<>();
    private Button btnSearch;
    private UserDto userDto;
    private WeatherInfoDto weatherInfoDto;
    private Label alertLabel;

    private DataTransferController() {
    }

    public String getDataInput() {
        return dataInput;
    }

    public void setDataInput(String dataInput) {
        this.dataInput = dataInput;
    }

    public AnchorPane getContent() {
        return content;
    }

    public void setContent(AnchorPane content) {
        this.content = content;
    }

    public Button getBtnCurrent() {
        return btnCurrent;
    }

    public void setBtnCurrent(Button btnCurrent) {
        this.btnCurrent = btnCurrent;
    }

    public Button getBtnData() {
        return btnData;
    }

    public void setBtnData(Button btnData) {
        this.btnData = btnData;
    }

    public Button getBtnHome() {
        return btnHome;
    }

    public void setBtnHome(Button btnHome) {
        this.btnHome = btnHome;
    }

    public Button getBtnFavorite() {
        return btnFavorite;
    }

    public void setBtnFavorite(Button btnFavorite) {
        this.btnFavorite = btnFavorite;
    }

    public Button getBtnHistory() {
        return btnHistory;
    }

    public void setBtnHistory(Button btnHistory) {
        this.btnHistory = btnHistory;
    }

    public Button getBtnAccount() {
        return btnAccount;
    }

    public void setBtnAccount(Button btnAccount) {
        this.btnAccount = btnAccount;
    }

    public FxWeaver getFxWeaver() {
        return fxWeaver;
    }

    public void setFxWeaver(FxWeaver fxWeaver) {
        this.fxWeaver = fxWeaver;
    }

    public Map<Class<?>, Button> getControllerButtonMap() {
        return controllerButtonMap;
    }

    public Button getBtnSearch() {
        return btnSearch;
    }

    public void setBtnSearch(Button btnSearch) {
        this.btnSearch = btnSearch;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public WeatherInfoDto getWeatherInfoDto() {
        return weatherInfoDto;
    }

    public void setWeatherInfoDto(WeatherInfoDto weatherInfoDto) {
        this.weatherInfoDto = weatherInfoDto;
    }

    public Label getAlertLabel() {
        return alertLabel;
    }

    public void setAlertLabel(Label alertLabel) {
        this.alertLabel = alertLabel;
    }

    /**
     * Public Static Method to Get the Singleton Instance:
     * @return
     */
    public static synchronized DataTransferController getInstance() {
        if (instance == null) {
            instance = new DataTransferController();
        }
        return instance;
    }

    public void initialize(FxWeaver fxWeaver, AnchorPane content, Button btnHome, Button btnData, Button btnCurrent, Button btnFavorite, Button btnHistory, Button btnAccount, Label alertLabel) {
        this.fxWeaver = fxWeaver;
        this.content = content;
        this.btnHome = btnHome;
        this.btnData = btnData;
        this.btnCurrent = btnCurrent;
        this.btnFavorite = btnFavorite;
        this.btnHistory = btnHistory;
        this.btnAccount = btnAccount;
        this.alertLabel = alertLabel;
        controllerButtonMap.put(HomeController.class, btnHome);
        controllerButtonMap.put(DataController.class, btnData);
        controllerButtonMap.put(CurrentController.class, btnCurrent);
        controllerButtonMap.put(FavoriteController.class, btnFavorite);
        controllerButtonMap.put(HistoryController.class, btnHistory);
        controllerButtonMap.put(AccountController.class, btnAccount);
    }

    public void loadLayout(Class<?> controllerClass) {
        if (fxWeaver == null) {
            log.error("FxWeaver is not initialized.");
            return;
        }

        Parent root = fxWeaver.loadView(controllerClass);
        if (root == null) {
            log.error("Failed to load view for {}", controllerClass.getSimpleName());
            return;
        }

        content.getChildren().clear();
        content.getChildren().setAll(root);

        Button selectedButton = controllerButtonMap.get(controllerClass);
        resetButtonStyle();
        if (selectedButton != null) {
            setButtonStyle(selectedButton);
        }
    }

    public void setButtonStyle(Button button) {
        button.setStyle("-fx-background-color: #4a6969; -fx-text-fill: white;");
    }

    public void resetButtonStyle() {
        if (btnHome != null) btnHome.setStyle("-fx-background-color: #7AB2B2; -fx-text-fill: white;");
        if (btnData != null) btnData.setStyle("-fx-background-color: #7AB2B2; -fx-text-fill: white;");
        if (btnCurrent != null) btnCurrent.setStyle("-fx-background-color: #7AB2B2; -fx-text-fill: white;");
        if (btnFavorite != null) btnFavorite.setStyle("-fx-background-color: #7AB2B2; -fx-text-fill: white;");
        if (btnHistory != null) btnHistory.setStyle("-fx-background-color: #7AB2B2; -fx-text-fill: white;");
        if (btnAccount != null) btnAccount.setStyle("-fx-background-color: #7AB2B2; -fx-text-fill: white;");
    }

}
