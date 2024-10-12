package fi.tuni.prog3.weatherapp.dto.weatherdtos;

/**
 * Represents system information received from the OpenWeatherMap API.
 */
public class SysDto {

    private int type; // Internal parameter

    private Long id; // Internal parameter

    private String country; // Country code

    private Long sunrise; // Sunrise time (UNIX timestamp)

    private Long sunset; // Sunset time (UNIX timestamp)

    /**
     * Gets the internal parameter 'type'.
     *
     * @return The internal parameter 'type' as an int.
     */
    public int getType() {
        return type;
    }

    /**
     * Sets the internal parameter 'type'.
     *
     * @param type The internal parameter 'type' to set.
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * Gets the internal parameter 'id'.
     *
     * @return The internal parameter 'id' as a Long.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the internal parameter 'id'.
     *
     * @param id The internal parameter 'id' to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the country code.
     *
     * @return The country code as a String.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the country code.
     *
     * @param country The country code to set.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets the sunrise time (UNIX timestamp).
     *
     * @return The sunrise time as a Long (UNIX timestamp).
     */
    public Long getSunrise() {
        return sunrise;
    }

    /**
     * Sets the sunrise time (UNIX timestamp).
     *
     * @param sunrise The sunrise time to set (UNIX timestamp).
     */
    public void setSunrise(Long sunrise) {
        this.sunrise = sunrise;
    }

    /**
     * Gets the sunset time (UNIX timestamp).
     *
     * @return The sunset time as a Long (UNIX timestamp).
     */
    public Long getSunset() {
        return sunset;
    }

    /**
     * Sets the sunset time (UNIX timestamp).
     *
     * @param sunset The sunset time to set (UNIX timestamp).
     */
    public void setSunset(Long sunset) {
        this.sunset = sunset;
    }
}