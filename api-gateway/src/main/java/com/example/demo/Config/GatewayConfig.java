package com.example.demo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class GatewayConfig {

	 @Bean
	    public RestClient.Builder restClientBuilder() {
	        return RestClient.builder();
	    }
}