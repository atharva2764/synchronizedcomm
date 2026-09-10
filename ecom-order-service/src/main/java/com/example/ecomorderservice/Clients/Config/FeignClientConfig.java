package com.example.ecomorderservice.Clients.Config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {

    @Bean
    public Logger.Level feignLoggerLeve(){
        return Logger.Level.FULL;
    }
}
