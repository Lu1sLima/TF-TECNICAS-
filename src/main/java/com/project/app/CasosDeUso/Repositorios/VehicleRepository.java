package com.project.app.CasosDeUso.Repositorios;

import com.project.app.Entidades.Vehicle;
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
