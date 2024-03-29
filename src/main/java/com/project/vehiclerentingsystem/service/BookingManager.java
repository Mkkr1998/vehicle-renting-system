package com.project.vehiclerentingsystem.service;

import com.project.vehiclerentingsystem.entity.Bookings;
import com.project.vehiclerentingsystem.entity.Vehicle;
import com.project.vehiclerentingsystem.repository.BookingRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingManager {
    VehicleManager vehicleManager;
    BookingRepo bookingRepo;

    BookingManager(VehicleManager vehicleManager,BookingRepo bookingRepo){
        this.bookingRepo=bookingRepo;
        this.vehicleManager=vehicleManager;
    }

    public List<Vehicle> bookedVehicle(LocalDateTime startTime, LocalDateTime endTime){
        return  bookingRepo.bookedVehicle(startTime,endTime);
    }

    public List<Vehicle> ifAvailable(Vehicle vehicle,LocalDateTime startTime, LocalDateTime endTime){
        List<Vehicle> set= bookedVehicle(startTime,endTime);
        System.out.println(set.toString());
        return vehicleManager.getAllVehicle().stream().filter(vehicle1 -> !set.contains(vehicle1))
                .filter(vehicle1 -> vehicle1.getBranch().getBranchName().equals(vehicle.getBranch().getBranchName()))
                .filter(vehicle2 -> {
                    if(vehicle.getType().equals("car")){
                        if(vehicle2.getType().equals("car"))
                        return vehicle2.getCarType().equals(vehicle.getCarType());
                        else return false;
                    }
                    else if(vehicle.getType().equals(vehicle2.getType())) return true;
                    return false;
                }).collect(Collectors.toList());
    }
    public Bookings bookVehicle(Vehicle vehicle,LocalDateTime startTime, LocalDateTime endTime){
        if(ifAvailable(vehicle,startTime,endTime).size()>0){
            Vehicle avVehicle = ifAvailable(vehicle,startTime,endTime).get(0);
            Bookings bookings = Bookings.builder()
                    .branch(avVehicle.getBranch())
                    .vehicle(avVehicle)
                    .startTime(startTime)
                    .endTime(endTime)
                    .build();
            return bookingRepo.save(bookings);
        }
        else return null;
    }
}
