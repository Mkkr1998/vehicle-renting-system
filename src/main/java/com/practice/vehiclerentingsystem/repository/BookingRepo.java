package com.practice.vehiclerentingsystem.repository;

import com.practice.vehiclerentingsystem.domain.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepo extends JpaRepository<Booking,Long> {
}
