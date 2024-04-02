package com.practice.vehiclerentingsystem.service;

import com.practice.vehiclerentingsystem.domain.entities.Branch;
import com.practice.vehiclerentingsystem.domain.entities.Vehicle;
import com.practice.vehiclerentingsystem.repository.VehicleRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VehicleService {
    private VehicleRepo vehicleRepo;
    private BranchService branchService;

    public Vehicle addVehicle(String branchName, Vehicle vehicle){
        Branch branch = branchService.getBranchByName(branchName);
        if(branch==null) return null;
        vehicle.setBranch(branch);
        return vehicleRepo.save(vehicle);
    }
    public List<Vehicle> getAllVehicle(){
        return vehicleRepo.findAll();
    }

}
