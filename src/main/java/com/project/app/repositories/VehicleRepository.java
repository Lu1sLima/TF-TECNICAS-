package com.project.app.repositories;

import com.project.app.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    Optional<Vehicle> findById(Long Id);

    List<Vehicle> findAll();

    Vehicle findByPlaca(String placa);

    Vehicle save(Vehicle vehicle);
}
