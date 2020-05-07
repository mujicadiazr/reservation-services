package com.mujicaservices.course.reservationservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ReservationServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservationServicesApplication.class, args);
	}

}
