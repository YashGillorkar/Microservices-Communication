package com.yash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class OrderServiceUsingResttemplateApplication {
	
	  @Bean
	    public RestTemplate restTemplate() {
	        return new RestTemplate();
	    }

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceUsingResttemplateApplication.class, args);
	}

}
