package com.project.vehiclerentingsystem.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Bookings {
    @Id
    private int bookingId;
    @JoinColumn(name = "branch_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Branch branch;
    @JoinColumn(name = "vehicle_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Vehicle vehicle;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
