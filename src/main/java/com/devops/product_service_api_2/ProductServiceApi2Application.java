package com.devops.product_service_api_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductServiceApi2Application {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApi2Application.class, args);
	}

}
