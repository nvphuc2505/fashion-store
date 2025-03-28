package com.fashion_store.order_service.config;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.net.URI;

@Data
@ConfigurationProperties(prefix = "polar")
public class ClientProperties {

    @NotNull
    private URI catalogServiceUri;

}
