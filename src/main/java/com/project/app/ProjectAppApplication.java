package com.project.app;


import com.project.app.CasosDeUso.Servicos.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


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
