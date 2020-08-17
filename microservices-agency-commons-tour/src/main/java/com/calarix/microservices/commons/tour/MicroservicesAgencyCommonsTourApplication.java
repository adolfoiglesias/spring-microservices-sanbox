package com.calarix.microservices.commons.tour;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class MicroservicesAgencyCommonsTourApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesAgencyCommonsTourApplication.class, args);
	}

}
