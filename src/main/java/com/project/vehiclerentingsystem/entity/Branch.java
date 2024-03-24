package com.project.vehiclerentingsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int branchId;
    private String branchName;
}
