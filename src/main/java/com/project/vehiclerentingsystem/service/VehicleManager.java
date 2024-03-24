package com.project.vehiclerentingsystem.service;

import com.project.vehiclerentingsystem.entity.Branch;
import com.project.vehiclerentingsystem.entity.Vehicle;
import com.project.vehiclerentingsystem.repository.VehicleRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VehicleManager {
    VehicleRepo vehicleRepo;

    public VehicleManager(VehicleRepo vehicleRepo) {
        this.vehicleRepo = vehicleRepo;

    }

    public Vehicle addVehicleInBranch(Vehicle vehicle){
        return vehicleRepo.save(vehicle);
    }
    public List<Vehicle> getAllVehicle(){
        return vehicleRepo.findAll();
    }
}
