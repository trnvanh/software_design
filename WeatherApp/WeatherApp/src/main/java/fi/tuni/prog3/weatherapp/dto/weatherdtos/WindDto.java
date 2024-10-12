package fi.tuni.prog3.weatherapp.dto.weatherdtos;

/**
 * Represents wind-related information retrieved from the OpenWeather API
 */
public class WindDto {
    private double windSpeed; // speed of wind

    private double windDirection; // direction of wind

    private double windGust; // gust of wind

    /**
     * Set the speed of wind
     * @param windSpeed double type
     */
    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    /**
     * Get the speed of wind information
     * @return double type data of wind speed
     */
    public double getWindSpeed() {
        return windSpeed;
    }

    /**
     * Get the direction of wind
     * @return double type data of wind direction
     */
    public double getWindDirection() {
        return windDirection;
    }

    /**
     * Set the direction of wind
     * @param windDirection double type data of direction
     */
    public void setWindDirection(double windDirection) {
        this.windDirection = windDirection;
    }

    /**
     * Get the gust of wind
     * @return double type data of wind gust
     */
    public double getWindGust() {
        return windGust;
    }

    /**
     * Set the gust of wind
     * @param windGust double type data of wind gust
     */
    public void setWindGust(double windGust) {
        this.windGust = windGust;
    }
}
