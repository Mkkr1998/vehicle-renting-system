package com.project.vehiclerentingsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int vehicleId;
    @JoinColumn(name = "branch_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Branch branch;
    private String type;
    private String carType;
    private int rate;

}
