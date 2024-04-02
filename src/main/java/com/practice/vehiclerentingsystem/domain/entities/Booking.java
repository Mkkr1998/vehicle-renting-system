package com.practice.vehiclerentingsystem.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    long bookId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_id")
    Vehicle vehicle;
    LocalDateTime startTime;
    LocalDateTime endTime;
}
