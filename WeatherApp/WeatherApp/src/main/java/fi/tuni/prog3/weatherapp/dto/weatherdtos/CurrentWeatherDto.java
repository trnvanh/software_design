package fi.tuni.prog3.weatherapp.dto.weatherdtos;

public class CurrentWeatherDto {
    private double temp;

    private double feelsLike;

    private TemperatureDto temperature;

    private double pressure;

    private double humidity;

    private double dewPoint;

    private double uvi;

    private double clouds;

    private double visibility;

    private double windSpeed;

    private WeatherDto weather;

    public double getClouds() {
        return clouds;
    }

    public double getDewPoint() {
        return dewPoint;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public double getTemp() {
        return temp;
    }

    public TemperatureDto getTemperature() {
        return temperature;
    }

    public double getUvi() {
        return uvi;
    }

    public double getVisibility() {
        return visibility;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setClouds(double clouds) {
        this.clouds = clouds;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public void setDewPoint(double dewPoint) {
        this.dewPoint = dewPoint;
    }

    public void setFeelsLike(double feelsLike) {
        this.feelsLike = feelsLike;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public WeatherDto getWeather() {
        return weather;
    }

    public void setTemperature(TemperatureDto temperature) {
        this.temperature = temperature;
    }

    public void setUvi(double uvi) {
        this.uvi = uvi;
    }

    public void setWeather(WeatherDto weather) {
        this.weather = weather;
    }

    public void setVisibility(double visibility) {
        this.visibility = visibility;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }
}
