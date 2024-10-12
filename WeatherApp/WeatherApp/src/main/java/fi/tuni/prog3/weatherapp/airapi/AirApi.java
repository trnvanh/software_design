package fi.tuni.prog3.weatherapp.airapi;

import fi.tuni.prog3.weatherapp.dto.airdtos.AirForecastDto;
import fi.tuni.prog3.weatherapp.dto.airdtos.ResponseDto;
import fi.tuni.prog3.weatherapp.dto.weatherdtos.ForecastDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class AirApi {

    // Define the base endpoints for the AirVisual API
    private static final String AIR_QUALITY_ENDPOINT = "/city";
    private static final String FORECAST_ENDPOINT = "/forecast";

    private final WebClient webClient;
    private final String airProjectUrl;
    private final String accessToken;

    // Constructor to inject WebClient, API URL, and access token
    public AirApi(final WebClient webClient,
                  @Value("${air.projectUrl}") String airProjectUrl,
                  @Value("${air.accessToken}") String accessToken) {
        this.webClient = webClient;
        this.airProjectUrl = airProjectUrl;
        this.accessToken = accessToken;
    }

    /**
     * Fetch air quality information for a specific location (nearest city to the given location).
     *
     * @param city The city or location query
     * @return ApiResponseDTO that contains weather and pollution data.
     */
    public ResponseDto getAirQualityInfo(final String city) {
        String uri = buildApiUri(city, AIR_QUALITY_ENDPOINT);

        return webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(ResponseDto.class)
                .block(); // Blocking call to get the data
    }

    /**
     * Fetch forecast information for a specific location.
     *
     * @param city The city or location query
     * @return ApiResponseDTO that contains forecast data.
     */
    public AirForecastDto getForecastInfo(final String city) {
        String uri = buildApiUri(city, FORECAST_ENDPOINT);

        return webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(AirForecastDto.class)
                .block();
    }

    /**
     * Helper method to build the URI for API requests.
     *
     * @param city The query for the location or city
     * @param endpoint The endpoint (either weather or forecast)
     * @return A fully constructed URI string
     */
    private String buildApiUri(String city, String endpoint) {
        return UriComponentsBuilder.fromUriString(airProjectUrl)
                .path(endpoint)
                .queryParam("city", city) // Adjusted parameter name to match AirVisual API
                .queryParam("key", accessToken) // API key for authentication
                .build()
                .toUriString();
    }

}
