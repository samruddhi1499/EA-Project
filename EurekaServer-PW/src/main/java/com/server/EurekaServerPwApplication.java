package com.server;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableEurekaServer
public class EurekaServerPwApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerPwApplication.class, args);
	}

}
