package fi.tuni.prog3.weatherapp.controller;

import fi.tuni.prog3.weatherapp.dto.userdtos.UserDto;
import fi.tuni.prog3.weatherapp.exception.UserNotFoundException;
import fi.tuni.prog3.weatherapp.service.UserService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
@FxmlView("/LogIn.fxml")
public class LogInController implements Initializable {
    private static final Logger log = LoggerFactory.getLogger(LogInController.class);

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;
    private final UserService userService;
    private final FxWeaver fxWeaver;

    @Autowired
    public LogInController(UserService userService, FxWeaver fxWeaver) {
        this.userService = userService;
        this.fxWeaver = fxWeaver;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        log.info("Initializing LogInController");
    }

    @FXML
    private void handleLogin() {
        var username = "user1";
        var password = "123456";

        try {
            UserDto userDto = userService.logIn(username, password);
            DataTransferController.getInstance().setUserDto(userDto);
            loadMainView();
        } catch (UserNotFoundException e) {
            log.info("Username or password is incorrect");
            showAlert("Login Fail", "Invalid username or password");
        } catch (Exception e) {
            log.error("An unexpected error occurred during login", e);
            showAlert("Error", "Something went wrong. Please try again.");
        }
    }

    public void handleEnterPressed(KeyEvent event) throws Exception {
        if (event.getCode() == KeyCode.ENTER) {
            handleLogin();
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(message);
        alert.showAndWait();
    }

    private void loadMainView() {
        Stage stage = (Stage) loginButton.getScene().getWindow();
        Scene mainScene = new Scene(fxWeaver.loadView(MainViewController.class));
        stage.setScene(mainScene);
    }
}