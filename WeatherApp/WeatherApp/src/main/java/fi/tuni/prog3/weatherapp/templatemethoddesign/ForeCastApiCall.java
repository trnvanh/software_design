package fi.tuni.prog3.weatherapp.templatemethoddesign;

import fi.tuni.prog3.weatherapp.dto.weatherdtos.ForeCastInfoDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.Map;

@Component
public class ForeCastApiCall extends ApiTemplate<ForeCastInfoDto> {

    private static final String FORECAST_ENDPOINT = "/forecast";

    private final String accessToken;

    public ForeCastApiCall(WebClient webClient,
                           @Value("${weather.projectUrl}") String weatherProjectUrl,
                           @Value("${weather.accessToken}") String accessToken) {
        super(webClient, weatherProjectUrl);
        this.accessToken = accessToken;
    }


    @Override
    protected String getEndpoint() {
        return FORECAST_ENDPOINT;
    }

    @Override
    protected Class<ForeCastInfoDto> getResponseType() {
        return ForeCastInfoDto.class;
    }

    public ForeCastInfoDto getForeCastByLocation(String location) {
        Map<String, String> params = new HashMap<>();
        params.put("appid", accessToken);
        params.put("units", "metric");
        params.put("q", location);
        return callApiFrom(params);
    }
}
