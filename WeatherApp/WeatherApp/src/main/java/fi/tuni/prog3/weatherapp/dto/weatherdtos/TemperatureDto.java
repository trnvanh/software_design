package fi.tuni.prog3.weatherapp.dto.weatherdtos;

public class TemperatureDto {
    private double maxTemp;
    private double minTemp;

    public double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }
}
