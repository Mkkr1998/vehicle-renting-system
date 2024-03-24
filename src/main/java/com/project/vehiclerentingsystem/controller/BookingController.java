package com.project.vehiclerentingsystem.controller;

import com.project.vehiclerentingsystem.entity.Bookings;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class BookingController {
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

}
