package fi.tuni.prog3.weatherapp.dto.weatherdtos;

public class LocationDto {
    private String cityName;
    private double lat;

    private double lon;
    private String country;
    private String state;

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getCountry() {
        return country;
    }

    public String getCityName() {
        return cityName;
    }

    public String getState() {
        return state;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setState(String state) {
        this.state = state;
    }
}

