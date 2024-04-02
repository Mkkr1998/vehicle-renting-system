package com.practice.vehiclerentingsystem.controller;

import com.practice.vehiclerentingsystem.domain.dto.BranchDTO;
import com.practice.vehiclerentingsystem.domain.entities.Branch;
import com.practice.vehiclerentingsystem.domain.entities.Vehicle;
import com.practice.vehiclerentingsystem.service.BranchService;
import com.practice.vehiclerentingsystem.utility.MapperClass;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class BranchController {
    BranchService branchService;
    @PostMapping("/addBranch")
    public Branch addBranch(@RequestBody BranchDTO branchDTO){
        List<Vehicle> vehicleList= MapperClass.mapToVehicleList(branchDTO.getVehicleList());
        Branch branch = Branch.builder()
                .branchName(branchDTO.getBranchName())
                .vehicleList(vehicleList)
                .build();
        return branchService.addBranch(branch);
    }
}
