package fi.tuni.prog3.weatherapp.weatherapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;

import fi.tuni.prog3.weatherapp.dto.weatherdtos.ForecastInfoDto;
import fi.tuni.prog3.weatherapp.dto.weatherdtos.WeatherInfoDto;
import org.springframework.stereotype.Component;

import org.springframework.web.util.UriComponentsBuilder;

@Component
public class WeatherApi {
    private static final String WEATHER_ENDPOINT = "/weather";
    private static final String FORECAST_ENDPOINT = "/forecast";
    private static final String QUERY_PARAM_QUERY = "q";
    private static final String QUERY_PARAM_APP_ID = "appid";
    private static final String UNITS_METRIC = "metric";
    private static final String UNITS = "units";
    private final WebClient webClient;
    private final String weatherProjectUrl;
    private final String accessToken;

    public WeatherApi(final WebClient webClient,
                      @Value("${weather.projectUrl}") String weatherProjectUrl,
                      @Value("${weather.accessToken}") String accessToken) {
        this.webClient = webClient;
        this.weatherProjectUrl = weatherProjectUrl;
        this.accessToken = accessToken;
    }

    public WeatherInfoDto weatherInfo(final String query) {
        var uri = buildAirQualityApiUri(query, WEATHER_ENDPOINT);

        return webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(WeatherInfoDto.class)
                .block();
    }

    public ForecastInfoDto foreCastInfo(final String query) {
        var uri = buildAirQualityApiUri(query, FORECAST_ENDPOINT);

        return webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(ForecastInfoDto.class)
                .block();
    }

    private String buildAirQualityApiUri(String query, String endpoint) {
        return UriComponentsBuilder.fromUriString(weatherProjectUrl)
                .path(endpoint)
                .queryParam(QUERY_PARAM_QUERY, query)
                .queryParam(QUERY_PARAM_APP_ID, accessToken)
                .queryParam(UNITS, UNITS_METRIC)
                .build()
                .toUriString();
    }

}
