package com.project.app.persistences;

import com.project.app.entities.Vehicle;
import com.project.app.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public abstract class VehicleRepositoryImpl implements VehicleRepository {

    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    public Optional<Vehicle> findById(Long Id) {
        return vehicleRepository.findById(Id);
    }


}
