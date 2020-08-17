package com.calarix.microservices.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan({"com.calarix.microservices.commons.user"})
@SpringBootApplication
public class MicroserviceUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceUserServiceApplication.class, args);
	}

}
