package com.practice.vehiclerentingsystem.controller;

import com.practice.vehiclerentingsystem.domain.dto.BookingDTO;
import com.practice.vehiclerentingsystem.domain.dto.VehicleDTO;
import com.practice.vehiclerentingsystem.service.BookingService;
import com.practice.vehiclerentingsystem.utility.MapperClass;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class BookController {
    BookingService bookingService;

    @PutMapping("/bookVehicle")
    public BookingDTO bookVehicle(@RequestBody BookingDTO bookingDTO){
        if(LocalDateTime.now().compareTo(bookingDTO.getStartTime())>=0) return null;
        if(bookingDTO.getEndTime().compareTo(bookingDTO.getStartTime())<=0) return null;
        return MapperClass.mapToBookingDTO(bookingService.bookCar(bookingDTO));
    }

    @GetMapping("/allBooking")
    public List<BookingDTO> getAllBookings(){
        return bookingService.getAllBookings().stream()
                .map(booking -> MapperClass.mapToBookingDTO(booking))
                .collect(Collectors.toList());
    }

    @GetMapping("/Bookings")
    public List<BookingDTO> getBookingsInBetween(@RequestBody BookingDTO bookingDTO){
        return bookingService.bookingsInBetween(bookingDTO.getStartTime(),bookingDTO.getEndTime())
                .stream()
                .map(booking -> MapperClass.mapToBookingDTO(booking))
                .collect(Collectors.toList());
    }
    @GetMapping("/getBookedVehicle")
    public List<VehicleDTO> getBookedVehicle(@RequestBody BookingDTO bookingDTO){
        return MapperClass.mapToVehicleDTOList(bookingService.getBookedVehicle(bookingDTO.getStartTime(),bookingDTO.getEndTime()));
    }

    @GetMapping("/getAvailableVehicle")
    public List<VehicleDTO> getAvailableVehicle(@RequestBody BookingDTO bookingDTO){
        return MapperClass.mapToVehicleDTOList(bookingService.getAvailableVehicle(bookingDTO.getStartTime(),bookingDTO.getEndTime()));
    }

    @GetMapping("/getAvailableVehicleAtBranch")
    public List<VehicleDTO> getAvailableVehicleAtBranch(@RequestBody BookingDTO bookingDTO){
        return MapperClass.mapToVehicleDTOList(bookingService.getAvailableVehicleAtBranch(bookingDTO.getBranchName(),bookingDTO.getStartTime(),bookingDTO.getEndTime()));
    }

}
