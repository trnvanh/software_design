package fi.tuni.prog3.weatherapp.templatemethoddesign;

import fi.tuni.prog3.weatherapp.exception.ClientErrorException;
import fi.tuni.prog3.weatherapp.exception.NetworkException;
import fi.tuni.prog3.weatherapp.exception.ResourceNotFoundException;
import fi.tuni.prog3.weatherapp.exception.ServerErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.StringJoiner;

/**
 * Template Method Pattern for Common API Call Structure.
 * <p>
 * This abstract class provides a template for making API calls. It handles common logic such as error
 * handling and URI construction, allowing subclasses to implement specific API call details.
 * The template method `callApiFrom` orchestrates the API call process by utilizing the
 * abstract methods `getEndpoint()` and `getResponseType()` which are to be implemented by the
 * subclasses for specific API configurations.
 * @param <T> The type of the response expected from the API call.
 */
public abstract class ApiTemplate<T> {
    private final WebClient webClient;
    private final String baseUrl;

    public ApiTemplate(WebClient webClient, String baseUrl) {
        this.webClient = webClient;
        this.baseUrl = baseUrl;
    }

    /**
     * Template method that defines the steps for making an API call.
     * It constructs the URI, makes the API call, and processes the response.
     * @param queryParams The query parameters to be sent with the API request.
     * @return The response of type T.
     */
    public T callApiFrom(Map<String, String> queryParams) {
        try {
            String uri = buildUri(queryParams, getEndpoint());
            return webClient.get()
                    .uri(uri)
                    .retrieve()
                    .onStatus(HttpStatus.NOT_FOUND::equals, response ->
                            Mono.error(new ResourceNotFoundException("Location not found: " + queryParams.get("q")))
                    )
                    .onStatus(HttpStatus::is4xxClientError, response ->
                            response.bodyToMono(String.class)
                                    .flatMap(body -> Mono.error(new ClientErrorException("Client error: " + body)))
                    )
                    .onStatus(HttpStatus::is5xxServerError, response ->
                            response.bodyToMono(String.class)
                                    .flatMap(body -> Mono.error(new ServerErrorException("Server error: " + body)))
                    )
                    .bodyToMono(getResponseType())
                    .block();
        } catch (WebClientRequestException e) {
            throw new NetworkException("Unable to connect to the weather service: " + e.getMessage());
        } catch (WebClientResponseException e) {
            throw new ClientErrorException("API response error: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error: " + e.getMessage(), e);
        }
    }

    /**
     * Abstract method to be implemented by subclasses to provide the specific API endpoint.
     */
    protected abstract String getEndpoint();

    /**
     * Abstract method to be implemented by subclasses to specify the expected response type.
     */
    protected abstract Class<T> getResponseType();

    /**
     * Build the URI from the base URL, endpoint, and query parameters.
     */
    protected String buildUri(Map<String, String> queryParams, String endpoint) {
        var uriBuilder = new StringBuilder(baseUrl);

        if (!endpoint.startsWith("/")) {
            uriBuilder.append("/");
        }
        uriBuilder.append(endpoint);

        if (queryParams != null && !queryParams.isEmpty()) {
            var queryParamsJoiner = new StringJoiner("&", "?", "");
            queryParams.forEach((key, value) ->
                    queryParamsJoiner.add(encodeParam(key) + "=" + encodeParam(value))
            );
            uriBuilder.append(queryParamsJoiner);
        }

        return uriBuilder.toString();
    }

    /**
     * URL encode a parameter using UTF-8 encoding.
     */
    private String encodeParam(String param) {
        try {
            return URLEncoder.encode(param, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException("Failed to encode parameter: " + param, e);
        }
    }
}
