package com.practice.vehiclerentingsystem.service;

import com.practice.vehiclerentingsystem.domain.dto.BookingDTO;
import com.practice.vehiclerentingsystem.domain.entities.Booking;
import com.practice.vehiclerentingsystem.domain.entities.Vehicle;
import com.practice.vehiclerentingsystem.repository.BookingRepo;
import com.practice.vehiclerentingsystem.utility.VehicleSelect;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookingService {
    BookingRepo bookingRepo;
    VehicleService vehicleService;
    public Booking bookCar(BookingDTO bookDTO){
        Vehicle vehicle = Vehicle.builder()
                .type(bookDTO.getType())
                .carType(bookDTO.getCarType())
                .build();
        List<Vehicle> vehicles = getVehicleAvailableForRentAtBranch(bookDTO.getBranchName(), vehicle, bookDTO.getStartTime(), bookDTO.getEndTime());
        if(vehicles.isEmpty()){
            vehicles = getAvailableVehicle(bookDTO.getStartTime(),bookDTO.getEndTime());
            Optional<Vehicle> vehicleLeft =VehicleSelect.vehicleSelectFromOtherBranch(vehicles,bookDTO.getType(),bookDTO.getCarType());
            if(!vehicleLeft.isPresent()) return null;
            Booking booking = Booking.builder()
                    .vehicle(vehicleLeft.get())
                    .startTime(bookDTO.getStartTime())
                    .endTime(bookDTO.getEndTime())
                    .build();
            return bookingRepo.save(booking);
        }
        else{
            Booking booking = Booking.builder()
                    .vehicle(VehicleSelect.vehicleSelectLowestRate(vehicles))
                    .startTime(bookDTO.getStartTime())
                    .endTime(bookDTO.getEndTime())
                    .build();
            return bookingRepo.save(booking);
        }
    }

    public List<Booking> getAllBookings(){
        return bookingRepo.findAll();
    }

    public List<Booking> bookingsInBetween(LocalDateTime startTime, LocalDateTime endTime){
        return bookingRepo.findAll().stream()
                .filter(booking -> !(booking.getStartTime().compareTo(startTime)>0 && booking.getStartTime().compareTo(endTime)>0) )
                .filter(booking -> !(booking.getEndTime().compareTo(startTime)<0 && booking.getEndTime().compareTo(endTime)<0))
                .collect(Collectors.toList());
    }

    public List<Vehicle> getBookedVehicle(LocalDateTime startTime, LocalDateTime endTime){
        return bookingsInBetween(startTime,endTime)
                .stream()
                .map(booking -> booking.getVehicle())
                .collect(Collectors.toList());
    }
    public List<Vehicle> getAvailableVehicle(LocalDateTime startTime, LocalDateTime endTime){
        List<Vehicle> bVehicle = getBookedVehicle(startTime,endTime);
        return vehicleService.getAllVehicle().stream()
                .filter(vehicle -> !bVehicle.contains(vehicle))
                .collect(Collectors.toList());
    }

    public List<Vehicle> getAvailableVehicleAtBranch(String branchName, LocalDateTime startTime, LocalDateTime endTime){
        return getAvailableVehicle(startTime,endTime).stream()
                .filter(vehicle -> vehicle.getBranch().getBranchName()
                        .equals(branchName))
                .collect(Collectors.toList());
    }

    public List<Vehicle> getVehicleAvailableForRentAtBranch(String branchName, Vehicle vehicle, LocalDateTime startTime, LocalDateTime endTime){
        return getAvailableVehicleAtBranch(branchName,startTime,endTime)
                .stream()
                .filter(v -> vehicle.getType().equals(v.getType()) && vehicle.getCarType()!=null?vehicle.getCarType().equals(v.getCarType()):true)
                .collect(Collectors.toList());
    }

}
