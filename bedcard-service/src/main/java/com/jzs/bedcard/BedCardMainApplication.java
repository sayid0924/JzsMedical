package com.jzs.bedcard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient

public class BedCardMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(BedCardMainApplication.class, args);
	}
}
