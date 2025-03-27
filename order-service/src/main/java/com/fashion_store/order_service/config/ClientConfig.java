package com.fashion_store.order_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ClientConfig {

    @Bean
    public WebClient webClient(WebClient.Builder webClientBuilder,
                               ClientProperties clientProperties) {

        return webClientBuilder
                .baseUrl(clientProperties.getCatalogServiceUri().toString())
                .build();
    }

}
