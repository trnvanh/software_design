package fi.tuni.prog3.weatherapp.templatemethoddesign;

import fi.tuni.prog3.weatherapp.dto.airdtos.AirQualityInfoDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.Map;

@Component
public class AirApiCall extends ApiTemplate<AirQualityInfoDto> {

    private static final String AIR_QUALITY_ENDPOINT = "/nearest_city";
    private final String accessToken;


    public AirApiCall(WebClient webClient,
                      @Value("${air.projectUrl}") String airProjectUrl,
                      @Value("${air.accessToken}") String accessToken) {
        super(webClient, airProjectUrl);
        this.accessToken = accessToken;
    }

    @Override
    protected String getEndpoint() {
        return AIR_QUALITY_ENDPOINT;
    }

    @Override
    protected Class<AirQualityInfoDto> getResponseType() {
        return AirQualityInfoDto.class;
    }

    public AirQualityInfoDto getAirQualityByCoordinates(double latitude, double longitude) {
        Map<String, String> params = new HashMap<>();
        params.put("lat", String.valueOf(latitude));
        params.put("lon", String.valueOf(longitude));
        params.put("key", accessToken);
        return callApiFrom(params);
    }
}
