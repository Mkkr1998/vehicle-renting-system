package com.project.vehiclerentingsystem.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class Bookings {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
