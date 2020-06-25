package com.project.app.Interfaces.RepositoriosImpl;

import com.project.app.Entidades.Vehicle;
import com.project.app.CasosDeUso.Repositorios.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public abstract class VehicleRepositoryImpl implements VehicleRepository {

    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    public Optional<Vehicle> findById(Long Id) {
        return vehicleRepository.findById(Id);
    }

    @Override
    public Vehicle findByPlaca(String placa) {
        return vehicleRepository.findByPlaca(placa);
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }
}
