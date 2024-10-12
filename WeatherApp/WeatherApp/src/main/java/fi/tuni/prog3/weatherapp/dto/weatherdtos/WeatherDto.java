package fi.tuni.prog3.weatherapp.dto.weatherdtos;

public class WeatherDto {
    private Long id;

    private String main;

    private String description;

    private String icon;

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getMain() {
        return main;
    }

    public String getIcon() {
        return icon;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setMain(String main) {
        this.main = main;
    }
}
