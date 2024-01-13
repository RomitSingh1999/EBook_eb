package com.Cataloguegrp.apiGateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class appConfig {

    @Bean
    public RestTemplate template(){
        return new RestTemplate();
    }
}