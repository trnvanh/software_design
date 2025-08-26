package fi.tuni.prog3.weatherapp.controller;

import fi.tuni.prog3.weatherapp.builderpattern.SearchHistory;
import fi.tuni.prog3.weatherapp.controller.support.HistoryDisplaySupport;
import fi.tuni.prog3.weatherapp.dto.historydtos.HistoryDto;
import fi.tuni.prog3.weatherapp.dto.userdtos.UserDto;
import fi.tuni.prog3.weatherapp.service.HistoryService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

@Component
@FxmlView("/HistoryLayout.fxml")
public class HistoryController implements Initializable {

    private static final Logger log = LoggerFactory.getLogger(HistoryController.class);

    @FXML
    public DatePicker historyFromDatePicker, historyToDatePicker;

    @FXML
    public TextField cityNameTextField;

    @FXML
    public Button historySearchButton;

    @FXML
    public TableView<HistoryDto> historyResultTable;

    @FXML
    private TableColumn<HistoryDto, String> idColumn, cityNameColumn, dateColumn, tempColumn;

    private final DataTransferController dataTransferController = DataTransferController.getInstance();
    private final HistoryDisplaySupport historyDisplaySupport = new HistoryDisplaySupport();

    @Autowired
    private HistoryService historyService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        log.info("Initializing HistoryController");
    }

    @FXML
    private void searchHistory() {
        log.info("Searching history");

        LocalDate fromDate = historyFromDatePicker.getValue();
        LocalDate toDate = historyToDatePicker.getValue();

        String cityName = cityNameTextField.getText();
        UserDto userDto = dataTransferController.getUserDto();
        Long userId = userDto.getId();

        SearchHistory searchCriteria = new SearchHistory.SearchBuilder(userId)
                .withCityName(cityName)
                .withFromDate(fromDate)
                .withToDate(toDate)
                .build();
        List<HistoryDto> historyDtoList = historyService.getHistory(searchCriteria);

        historyDisplaySupport.displayHistoryTable(historyDtoList, historyResultTable, idColumn, cityNameColumn, dateColumn, tempColumn);
    }
}
