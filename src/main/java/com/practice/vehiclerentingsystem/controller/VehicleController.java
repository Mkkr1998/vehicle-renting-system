package com.practice.vehiclerentingsystem.controller;

import com.practice.vehiclerentingsystem.domain.dto.BookingDTO;
import com.practice.vehiclerentingsystem.domain.dto.VehicleDTO;
import com.practice.vehiclerentingsystem.domain.entities.Vehicle;
import com.practice.vehiclerentingsystem.service.BookingService;
import com.practice.vehiclerentingsystem.service.VehicleService;
import com.practice.vehiclerentingsystem.utility.MapperClass;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class VehicleController {
    VehicleService vehicleService;

    @PutMapping("/addVehicle")
    public VehicleDTO addVehicle(@RequestBody VehicleDTO vehicleDTO){
        Vehicle vehicle = Vehicle.builder()
                .rate(vehicleDTO.getRate())
                .type(vehicleDTO.getType())
                .carType(vehicleDTO.getCarType())
                .build();

        return MapperClass.mapToVehicleDTO(vehicleService.addVehicle(vehicleDTO.getBranchName(),vehicle));
    }

    @GetMapping("/getVehicle")
    public List<VehicleDTO> getVehicle(){
        return MapperClass.mapToVehicleDTOList(vehicleService.getAllVehicle());
    }


}
