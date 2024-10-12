package fi.tuni.prog3.weatherapp.service;

import fi.tuni.prog3.weatherapp.airapi.AirApi;
import fi.tuni.prog3.weatherapp.dto.airdtos.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirServiceTest {

    private final AirApi airApi;

    @Autowired
    public AirServiceTest(AirApi airApi) {
        this.airApi = airApi;
    }

    /**
     * Fetch and print air quality data for a given city.
     *
     * @param city The city name for which you want to fetch the air quality data.
     */
    public void fetchAndPrintAirQuality(String city) {
        // Fetch the air quality data from AirApi
        ResponseDto airQualityInfo = airApi.getAirQualityInfo(city);

        // Print out some details from the air quality data
        if (airQualityInfo != null && airQualityInfo.getAirData() != null) {
            System.out.println("City: " + airQualityInfo.getAirData().getCity());
            System.out.println("Country: " + airQualityInfo.getAirData().getCountry());

            // Current air quality information
            if (airQualityInfo.getAirData().getCurrent() != null
                    && airQualityInfo.getAirData().getCurrent().getPollution() != null) {

                System.out.println("AQI (US): " + airQualityInfo.getAirData().getCurrent().getPollution().getAqiUs());
                System.out.println("Main Pollutant (US): " + airQualityInfo.getAirData().getCurrent().getPollution().getMainUs());
                System.out.println("AQI (CN): " + airQualityInfo.getAirData().getCurrent().getPollution().getAqiCn());
                System.out.println("Main Pollutant (CN): " + airQualityInfo.getAirData().getCurrent().getPollution().getMainCn());
            } else {
                System.out.println("No current pollution data available.");
            }
        } else {
            System.out.println("No data available for the specified city.");
        }
    }
}
