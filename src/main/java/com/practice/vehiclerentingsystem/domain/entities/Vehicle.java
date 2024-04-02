package com.practice.vehiclerentingsystem.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.Vector;

@Entity
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    long vehicleId;
    String type;
    int rate;
    String carType;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "branch_id")
    Branch branch;
}
