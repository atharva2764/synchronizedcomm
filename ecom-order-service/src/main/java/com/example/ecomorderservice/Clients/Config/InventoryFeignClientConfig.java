package com.example.ecomorderservice.Clients.Config;

import feign.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.UUID;

@Configuration
public class InventoryFeignClientConfig {

    @Bean
    public Logger.Level feignInvLoggerLevel() {
        return Logger.Level.BASIC;
    }

    @Bean
    public Request.Options options() {
        return new Request.Options(3000, 2000);
    }

    @Bean
    public Retryer retryer() {
        return new Retryer.Default(1L, 2L, 3);

    }


    // for ur authentication tocken header and all
    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("x-Collrelation-Id", UUID.randomUUID().toString());
        };
    }
}
