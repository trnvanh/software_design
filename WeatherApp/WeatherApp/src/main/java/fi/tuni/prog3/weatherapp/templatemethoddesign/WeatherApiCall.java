package fi.tuni.prog3.weatherapp.templatemethoddesign;

import fi.tuni.prog3.weatherapp.dto.weatherdtos.WeatherInfoDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.Map;

@Component
public class WeatherApiCall extends ApiTemplate<WeatherInfoDto> {

    private static final String WEATHER_ENDPOINT = "/weather";
    private final String accessToken;

    public WeatherApiCall(WebClient webClient,
                          @Value("${weather.projectUrl}") String weatherProjectUrl,
                          @Value("${weather.accessToken}") String accessToken) {
        super(webClient, weatherProjectUrl);
        this.accessToken = accessToken;
    }

    @Override
    protected String getEndpoint() {
        return WEATHER_ENDPOINT;
    }

    @Override
    protected Class<WeatherInfoDto> getResponseType() {
        return WeatherInfoDto.class;
    }

    public WeatherInfoDto getWeatherByLocation(String location) {
        Map<String, String> params = new HashMap<>();
        params.put("appid", accessToken);
        params.put("units", "metric");
        params.put("q", location);
        return callApiFrom(params);
    }

}
