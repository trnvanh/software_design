package fi.tuni.prog3.weatherapp.config;

import fi.tuni.prog3.weatherapp.WeatherSystemApplication;
import fi.tuni.prog3.weatherapp.controller.LogInController;
import fi.tuni.prog3.weatherapp.controller.MainViewController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import lombok.Setter;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Objects;

@Setter
public class WeatherApp extends Application {

    private ConfigurableApplicationContext applicationContext;

    @Override
    public void init() {
        String[] args = getParameters().getRaw().toArray(new String[0]);
        this.applicationContext = new SpringApplicationBuilder()
                .sources(WeatherSystemApplication.class)
                .run(args);
    }

    @Override
    public void start(Stage stage) {
        try {
            FxWeaver fxWeaver = applicationContext.getBean(FxWeaver.class);
            Parent root = fxWeaver.loadView(LogInController.class);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Weather App");

            Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/icon/logo.png")));
            stage.getIcons().add(icon);

            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {
        this.applicationContext.close();
        Platform.exit();
    }
}