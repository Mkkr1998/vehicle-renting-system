package com.project.vehiclerentingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.Iterator;

@SpringBootApplication
public class VehicleRentingSystemApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(VehicleRentingSystemApplication.class, args);
	}

}
