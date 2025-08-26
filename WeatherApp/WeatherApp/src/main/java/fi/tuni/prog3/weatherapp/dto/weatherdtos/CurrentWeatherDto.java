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

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(double feelsLike) {
        this.feelsLike = feelsLike;
    }

    public TemperatureDto getTemperature() {
        return temperature;
    }

    public void setTemperature(TemperatureDto temperature) {
        this.temperature = temperature;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getDewPoint() {
        return dewPoint;
    }

    public void setDewPoint(double dewPoint) {
        this.dewPoint = dewPoint;
    }

    public double getUvi() {
        return uvi;
    }

    public void setUvi(double uvi) {
        this.uvi = uvi;
    }

    public double getClouds() {
        return clouds;
    }

    public void setClouds(double clouds) {
        this.clouds = clouds;
    }

    public double getVisibility() {
        return visibility;
    }

    public void setVisibility(double visibility) {
        this.visibility = visibility;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public WeatherDto getWeather() {
        return weather;
    }

    public void setWeather(WeatherDto weather) {
        this.weather = weather;
    }
}
