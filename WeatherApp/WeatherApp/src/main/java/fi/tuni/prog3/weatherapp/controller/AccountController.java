package fi.tuni.prog3.weatherapp.controller;

import fi.tuni.prog3.weatherapp.dto.userdtos.UserDto;
import fi.tuni.prog3.weatherapp.service.UserService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

@FxmlView("/AccountLayout.fxml")
@Component
public class AccountController implements Initializable {

    private static final Logger log = LoggerFactory.getLogger(AccountController.class);
    private final DataTransferController dataTransferController = DataTransferController.getInstance();

    @FXML
    private TextField nameField, ageField, addressField, cityField, countryField, usernameField, passwordField;

    @FXML
    private Button btnSaveUserAcc;

    private final UserService userService;

    public AccountController(final UserService userService) {
        this.userService = userService;
    }

    @Override
    public void initialize(final URL url, final ResourceBundle resourceBundle) {
        log.info("Initializing AccountController");
        refresh();
    }

    public void refresh() {
        log.info("Refreshing AccountController");
        var userDto = dataTransferController.getUserDto();
        if (userDto == null) {
            log.warn("No user data available to refresh UI");
            return;
        }
        var fieldMappings = Map.of(
                usernameField, userDto.getUsername(),
                passwordField, userDto.getPassword(),
                nameField, userDto.getFullName(),
                ageField, userDto.getAge(),
                addressField, userDto.getAddress(),
                cityField, userDto.getCity(),
                countryField, userDto.getCountry()
        );
        fieldMappings.forEach(TextField::setText);
    }

    @FXML
    public void saveAccount() {
        try {
            var userDto = dataTransferController.getUserDto();

            var name = nameField.getText();
            var age = getAgeFromField(ageField.getText());
            var address = addressField.getText();
            var city = cityField.getText();
            var country = countryField.getText();
            var username = usernameField.getText();
            var password = passwordField.getText();

            if (isBlank(username) || isBlank(password)) {
                showMessage("Username and password must not be blank.");
                return;
            }

            var updatedUser = createUpdatedUser(userDto, name, age, address, city, country, username, password);
            userService.updateUserInfo(userDto.getId(), updatedUser);
            dataTransferController.setUserDto(updatedUser);

            showMessage("Account details updated successfully!");

        } catch (NumberFormatException e) {
            showMessage("Invalid age. Please enter a valid number.");
        } catch (IllegalArgumentException e) {
            showMessage(e.getMessage());
        } catch (Exception e) {
            log.error("Failed to save account details", e);
            showMessage("An error occurred while updating account details. Please try again.");
        }
    }

    private boolean isBlank(final String value) {
        return value == null || value.isBlank();
    }

    private int getAgeFromField(final String ageFieldText) {
        try {
            return Integer.parseInt(ageFieldText);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid age. Please enter a valid number.");
        }
    }

    private UserDto createUpdatedUser(final UserDto userDto,
                                      final String name,
                                      final int age,
                                      final String address,
                                      final String city,
                                      final String country,
                                      final String username,
                                      final String password) {
        var updatedUser = new UserDto();
        updatedUser.setId(userDto.getId());
        updatedUser.setFullName(name);
        updatedUser.setAge(String.valueOf(age));
        updatedUser.setAddress(address);
        updatedUser.setCity(city);
        updatedUser.setCountry(country);
        updatedUser.setUsername(username);
        updatedUser.setPassword(password);
        return updatedUser;
    }

    private void showMessage(final String message) {
        var alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Notification");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
