package com.project.vehiclerentingsystem.repository;

import com.project.vehiclerentingsystem.entity.Bookings;
import com.project.vehiclerentingsystem.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface BookingRepo extends JpaRepository<Bookings, Integer> {
    @Query("SELECT vehicle FROM Bookings b WHERE b.startTime BETWEEN ?1 AND ?2 OR b.endTime BETWEEN ?1 AND ?2")
    List<Vehicle> bookedVehicle(LocalDateTime startTime,LocalDateTime endTime);
}
