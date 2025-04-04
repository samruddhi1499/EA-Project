package com.service.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FeePwApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeePwApplication.class, args);
	}

}
