package com.practice.vehiclerentingsystem.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingDTO {
    String branchName;
    String type;
    String CarType;
    LocalDateTime startTime;
    LocalDateTime endTime;
    double fair;
}
