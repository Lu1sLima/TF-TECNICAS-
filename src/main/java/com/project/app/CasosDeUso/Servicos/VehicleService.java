package com.project.app.CasosDeUso.Servicos;

import com.project.app.Entidades.Vehicle;
import com.project.app.CasosDeUso.Repositorios.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    public Vehicle findVehicleByPlaca(String placa){
        return vehicleRepository.findByPlaca(placa);
    }

    public Optional<Vehicle> findVehicleById(Long id){
        return vehicleRepository.findById(id);
    }

    public Vehicle addVehicle(Vehicle vehicle){ return vehicleRepository.save(vehicle);}
}
