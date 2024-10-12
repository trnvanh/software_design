package fi.tuni.prog3.weatherapp.dto.weatherdtos;

public class CloudDto {
    private double cloudPercentage; // percentage of coverage

    public double getCloudPercentage() {
        return cloudPercentage;
    }

    public void setCloudPercentage(double cloudPercentage) {
        this.cloudPercentage = cloudPercentage;
    }
}
