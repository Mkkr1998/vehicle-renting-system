package com.project.vehiclerentingsystem.controller;

import com.project.vehiclerentingsystem.entity.Branch;
import com.project.vehiclerentingsystem.entity.Vehicle;
import com.project.vehiclerentingsystem.service.BranchManager;
import com.project.vehiclerentingsystem.service.VehicleManager;
import org.springframework.web.bind.annotation.*;

@RestController
public class BranchController {

    BranchManager branchManager;
    VehicleManager vehicleManager;

    BranchController(BranchManager branchManager,VehicleManager vehicleManager){
        this.branchManager=branchManager;
        this.vehicleManager=vehicleManager;
    }
    @PostMapping("/branch")
    public Vehicle addBranchAndVehicle(@RequestBody Vehicle vehicle){
        System.out.println(vehicle.toString());
        if(branchManager.getBranch(vehicle.getBranch().getBranchName())!=null){
            Branch branch=branchManager.getBranch(vehicle.getBranch().getBranchName());
            vehicle.setBranch(branch);
        }
        return vehicleManager.addVehicleInBranch(vehicle);
    }

    @PutMapping("/branch/{branchName}")
    public Vehicle addVehicleInBranch(@PathVariable String branchName,@RequestBody Vehicle vehicle){
        if(branchManager.getBranch(vehicle.getBranch().getBranchName())!=null){
            Branch branch=branchManager.getBranch(vehicle.getBranch().getBranchName());
            vehicle.setBranch(branch);
        }
        return vehicleManager.addVehicleInBranch(vehicle);
    }
}
