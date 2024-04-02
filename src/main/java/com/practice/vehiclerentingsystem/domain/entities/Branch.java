package com.practice.vehiclerentingsystem.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    long branchId;
    String branchName;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "branch_id")
    List<Vehicle> vehicleList;
}
