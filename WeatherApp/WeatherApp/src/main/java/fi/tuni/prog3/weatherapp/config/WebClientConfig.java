package fi.tuni.prog3.weatherapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Configuration class for creating a WebClient bean.
 * This class is annotated with {@link Configuration} to indicate that it provides bean definitions.
 */
@Configuration
public class WebClientConfig {

    /**
     * Creates and configures a {@link WebClient} bean.
     *
     * @return The configured WebClient bean.
     */
    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .build();
    }
}