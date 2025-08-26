package fi.tuni.prog3.weatherapp.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
@FxmlView("/MainView.fxml")
public class MainViewController implements Initializable {
    private static final Logger log = LoggerFactory.getLogger(MainViewController.class);

    @FXML
    @Getter
    private AnchorPane content;

    @FXML
    private Button btnCurrent;
    @FXML
    private Button btnData;
    @FXML
    private Button btnHome;
    @FXML
    private Button btnFavorite;
    @FXML
    private Button btnHistory;
    @FXML
    private Button btnLogOut;
    @FXML
    private Button btnAccount;

    @Autowired
    private FxWeaver fxWeaver;

    private final DataTransferController dataTransferController = DataTransferController.getInstance();

    @FXML
    private Label alertLabel;

    /**
     * Alert message
     */
    public void setAlertMsg(String alertMsg) {
        alertLabel.setText(alertMsg);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        dataTransferController.initialize(fxWeaver, content, btnHome, btnData, btnCurrent, btnFavorite, btnHistory, btnAccount, alertLabel);

        Platform.runLater(this::initHomeView);
    }

    private void initHomeView() {
        dataTransferController.loadLayout(HomeController.class);
    }

    @FXML
    void loadHomeLayout(ActionEvent event) {
        dataTransferController.loadLayout(HomeController.class);
    }

    @FXML
    void loadDataLayout(ActionEvent event) {
        dataTransferController.loadLayout(DataController.class);
    }

    @FXML
    void loadCurrentLayout(ActionEvent event) {
        dataTransferController.loadLayout(CurrentController.class);
    }

    @FXML
    void loadFavoriteLayout(ActionEvent event) {
        dataTransferController.loadLayout(FavoriteController.class);
    }

    @FXML
    void loadHistoryLayout(ActionEvent event) {
        dataTransferController.loadLayout(HistoryController.class); }

    @FXML
    void loadAccountLayout(ActionEvent event) {
        dataTransferController.loadLayout(AccountController.class); }


    @FXML
    public void loadLogInLayout(ActionEvent actionEvent) {
        Stage stage = (Stage) btnLogOut.getScene().getWindow(); // Get current stage
        Scene mainScene = new Scene(fxWeaver.loadView(LogInController.class)); // Load MainView scene

        stage.setScene(mainScene); // Set the new scene on the stage
        stage.show(); // Show the main view
    }
}