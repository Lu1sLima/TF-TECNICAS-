package com.project.app;


import com.project.app.entities.User;
import com.project.app.entities.Vehicle;
import com.project.app.repositories.VehicleRepository;
import com.project.app.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;


@SpringBootApplication
public class ProjectAppApplication implements CommandLineRunner {

	@Autowired
	VehicleService vehicleService;

	public static void main(String[] args) {
		SpringApplication.run(ProjectAppApplication.class, args);

	}



	@Override
	public void run(String... args) throws Exception {
		System.out.println(vehicleService.findVehicleById(1L));
	}
}
