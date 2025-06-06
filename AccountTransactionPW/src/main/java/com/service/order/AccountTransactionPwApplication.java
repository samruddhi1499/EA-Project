package com.service.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AccountTransactionPwApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountTransactionPwApplication.class, args);
	}

}
