package com.practice.vehiclerentingsystem.repository;

import com.practice.vehiclerentingsystem.domain.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepo extends JpaRepository<Vehicle,Long> {
}
