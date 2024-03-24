package com.project.vehiclerentingsystem.controller;

import com.project.vehiclerentingsystem.entity.Bookings;
import com.project.vehiclerentingsystem.entity.Vehicle;
import com.project.vehiclerentingsystem.service.BookingManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
public class BookingController {

    private BookingManager bookingManager;
    BookingController(BookingManager bookingManager){
        this.bookingManager=bookingManager;
    }
    @GetMapping("/check")
    public Boolean checkLocalTimeIsWorking(@RequestBody Bookings bookings){
        LocalDateTime t1=bookings.getStartTime();
        LocalDateTime t2 = bookings.getEndTime();
        return t1.compareTo(t2)==1?false:true;

        //{
        //    "bookingId":1,
        //    "branch":null,
        //    "vehicle":null,
        //    "startTime":"2024-03-18T22:00",
        //    "endTime":"2024-03-17T22:00"
        //
        //} JSON TO CHECK
    }

    @PutMapping("/bookvehicle")
    public Bookings doBooking(@RequestBody Bookings bookings){
        Vehicle vehicle=bookings.getVehicle();
        return bookingManager.bookVehicle(vehicle,bookings.getStartTime(),bookings.getEndTime());
    }

    @GetMapping("/bookings")
    public List<Vehicle> allBookings(@RequestBody Map<String,String> map){
        String startTime = map.get("startTIme");
        String endTIme= map.get("endTime");
        return bookingManager.bookedVehicle(LocalDateTime.parse(startTime),LocalDateTime.parse(endTIme));
    }
}
