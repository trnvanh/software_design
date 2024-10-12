package fi.tuni.prog3.weatherapp.dto.airdtos;

public class AirForecastDto {
    private String ts; // timestamp

    private double aqiUs; // AQI value based on US standards

    private double aqiCn; // AQI value based on China standards

    private double temperature; // temperature in Celsius

    private double minTemperature; // minimum temp in Celsius

    private double pressure; // atmospheric pressure

    private double humidity; // humidity

    private double windSpeed; // wind_speed

    private double windDirection; // wind_direction

    private String iconCode; // weather icon code

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public void setAqiCn(double aqiCn) {
        this.aqiCn = aqiCn;
    }

    public void setAqiUs(double aqiUs) {
        this.aqiUs = aqiUs;
    }

    public void setIconCode(String iconCode) {
        this.iconCode = iconCode;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public void setMinTemperature(double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public void setWindDirection(double windDirection) {
        this.windDirection = windDirection;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getPressure() {
        return pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getAqiCn() {
        return aqiCn;
    }

    public double getAqiUs() {
        return aqiUs;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getWindDirection() {
        return windDirection;
    }

    public double getWindSpeed() {
        return windSpeed;
    }
}
