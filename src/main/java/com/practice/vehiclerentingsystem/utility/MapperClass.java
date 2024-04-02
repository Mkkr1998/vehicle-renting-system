package com.practice.vehiclerentingsystem.utility;

import com.practice.vehiclerentingsystem.domain.dto.BookingDTO;
import com.practice.vehiclerentingsystem.domain.dto.VehicleDTO;
import com.practice.vehiclerentingsystem.domain.entities.Booking;
import com.practice.vehiclerentingsystem.domain.entities.Vehicle;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class MapperClass {
    public static List<Vehicle> mapToVehicleList(List<VehicleDTO> vehicleDTOList){
        return vehicleDTOList.stream()
                .map(vehicleDTO -> Vehicle.builder().type(vehicleDTO.getType())
                        .rate(vehicleDTO.getRate())
                        .carType(vehicleDTO.getCarType()).build())
                .collect(Collectors.toList());
    }
    public static List<VehicleDTO> mapToVehicleDTOList(List<Vehicle> vehicleList){
        return vehicleList.stream()
                .map(vehicle -> VehicleDTO.builder().type(vehicle.getType()).carType(vehicle.getCarType())
                        .rate(vehicle.getRate())
                        .BranchName(vehicle.getBranch().getBranchName()).build())
                .collect(Collectors.toList());
    }

    public static VehicleDTO mapToVehicleDTO(Vehicle vehicle) {
        return VehicleDTO.builder()
                .BranchName(vehicle.getBranch().getBranchName())
                .rate(vehicle.getRate())
                .type(vehicle.getType())
                .carType(vehicle.getCarType())
                .build();
    }
    public static Vehicle mapToVehicle(VehicleDTO vehicleDTO) {
        return Vehicle.builder()
                .rate(vehicleDTO.getRate())
                .type(vehicleDTO.getType())
                .carType(vehicleDTO.getCarType())
                .build();
    }

    public static BookingDTO mapToBookingDTO(Booking booking) {
        if(booking==null) return null;
        Duration duration = Duration.between(booking.getStartTime(), booking.getEndTime());
        double cost= duration.toHours()*booking.getVehicle().getRate();
        return BookingDTO.builder()
                .branchName(booking.getVehicle().getBranch().getBranchName())
                .startTime(booking.getStartTime())
                .endTime(booking.getEndTime())
                .type(booking.getVehicle().getType())
                .CarType(booking.getVehicle().getCarType())
                .fair(cost)
                .build();
    }
}
