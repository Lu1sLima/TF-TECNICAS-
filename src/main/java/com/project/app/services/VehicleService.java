package com.project.app.services;

import com.project.app.entities.Vehicle;
import com.project.app.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    public Optional<Vehicle> findVehicleById(Long id){
        return vehicleRepository.findById(id);
    }
}
