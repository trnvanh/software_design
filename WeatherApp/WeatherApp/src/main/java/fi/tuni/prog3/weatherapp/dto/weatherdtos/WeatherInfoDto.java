package fi.tuni.prog3.weatherapp.dto.weatherdtos;

import java.util.List;

/**
 * Represents detailed weather information received from the OpenWeatherMap API.
 */
public class WeatherInfoDto {

    private LocationDto location; // Coordinates of the location

    private List<WeatherDto> weather; // List of weather conditions

    private String base; // Internal parameter

    private MainDto main; // Main weather information

    private Long visibility; // Visibility in meters

    private WindDto wind; // Wind information

    private CloudDto clouds; // Clouds information

    private Long dt; // Time of data calculation in seconds since 1970

    private SysDto sys; // System information

    private Long timezone; // Shift in seconds from UTC

    private Long id; // City ID

    private String name; // City name

    private Long cod; // Internal parameter

    /**
     * Gets the coordinates of the location.
     *
     * @return The coordinates of the location as a CoordDto object.
     */
    public LocationDto getLocation() {
        return location;
    }

    /**
     * Sets the coordinates of the location.
     *
     * @param location The coordinates of the location to set.
     */
    public void setLocation(LocationDto location) {
        this.location = location;
    }

    /**
     * Gets the list of weather conditions.
     *
     * @return The list of weather conditions as a List of WeatherDto objects.
     */
    public List<WeatherDto> getWeather() {
        return weather;
    }

    /**
     * Sets the list of weather conditions.
     *
     * @param weather The list of weather conditions to set.
     */
    public void setWeather(List<WeatherDto> weather) {
        this.weather = weather;
    }

    /**
     * Gets the internal parameter.
     *
     * @return The internal parameter as a String.
     */
    public String getBase() {
        return base;
    }

    /**
     * Sets the internal parameter.
     *
     * @param base The internal parameter to set.
     */
    public void setBase(String base) {
        this.base = base;
    }

    /**
     * Gets the main weather information.
     *
     * @return The main weather information as a MainDto object.
     */
    public MainDto getMain() {
        return main;
    }

    /**
     * Sets the main weather information.
     *
     * @param main The main weather information to set.
     */
    public void setMain(MainDto main) {
        this.main = main;
    }

    /**
     * Gets the visibility in meters.
     *
     * @return The visibility in meters as a Long.
     */
    public Long getVisibility() {
        return visibility;
    }

    /**
     * Sets the visibility in meters.
     *
     * @param visibility The visibility in meters to set.
     */
    public void setVisibility(Long visibility) {
        this.visibility = visibility;
    }

    /**
     * Gets the wind information.
     *
     * @return The wind information as a WindDto object.
     */
    public WindDto getWind() {
        return wind;
    }

    /**
     * Sets the wind information.
     *
     * @param wind The wind information to set.
     */
    public void setWind(WindDto wind) {
        this.wind = wind;
    }

    /**
     * Gets the clouds information.
     *
     * @return The clouds information as a CloudsDto object.
     */
    public CloudDto getClouds() {
        return clouds;
    }

    /**
     * Sets the clouds information.
     *
     * @param clouds The clouds information to set.
     */
    public void setClouds(CloudDto clouds) {
        this.clouds = clouds;
    }

    /**
     * Gets the time of data calculation in seconds since 1970.
     *
     * @return The time of data calculation in seconds since 1970 as a Long.
     */
    public Long getDt() {
        return dt;
    }

    /**
     * Sets the time of data calculation in seconds since 1970.
     *
     * @param dt The time of data calculation in seconds since 1970 to set.
     */
    public void setDt(Long dt) {
        this.dt = dt;
    }

    /**
     * Gets the system information.
     *
     * @return The system information as a SysDto object.
     */
    public SysDto getSys() {
        return sys;
    }

    /**
     * Sets the system information.
     *
     * @param sys The system information to set.
     */
    public void setSys(SysDto sys) {
        this.sys = sys;
    }

    /**
     * Gets the shift in seconds from UTC.
     *
     * @return The shift in seconds from UTC as a Long.
     */
    public Long getTimezone() {
        return timezone;
    }

    /**
     * Sets the shift in seconds from UTC.
     *
     * @param timezone The shift in seconds from UTC to set.
     */
    public void setTimezone(Long timezone) {
        this.timezone = timezone;
    }

    /**
     * Gets the city ID.
     *
     * @return The city ID as a Long.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the city ID.
     *
     * @param id The city ID to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the city name.
     *
     * @return The city name as a String.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the city name.
     *
     * @param name The city name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the internal parameter.
     *
     * @return The internal parameter as a Long.
     */
    public Long getCod() {
        return cod;
    }

    /**
     * Sets the internal parameter.
     *
     * @param cod The internal parameter to set.
     */
    public void setCod(Long cod) {
        this.cod = cod;
    }
}
