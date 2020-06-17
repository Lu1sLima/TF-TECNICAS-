package com.project.app.repositories;

import com.project.app.entities.User;
import com.project.app.entities.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Long> {

    Optional<Vehicle> findById(Long Id);

    Iterable<Vehicle> findAll();
}
