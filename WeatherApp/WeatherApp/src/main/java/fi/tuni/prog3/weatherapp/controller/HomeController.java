package fi.tuni.prog3.weatherapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
public class HomeController {
    @FXML
    private Button btnSearch;

    @FXML
    private TextField inputSearch;

    @FXML
    void search(ActionEvent event) {

    }
}
