package com.dcl.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringRestProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestProductApplication.class, args);
	}
}
