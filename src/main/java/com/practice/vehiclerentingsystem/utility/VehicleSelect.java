package com.practice.vehiclerentingsystem.utility;

import com.practice.vehiclerentingsystem.domain.entities.Vehicle;

import java.util.List;
import java.util.Optional;

public class VehicleSelect {

    public static Vehicle vehicleSelectLowestRate(List<Vehicle> vehicleList){
        return vehicleList.stream()
                .reduce((v1,v2)-> v1.getRate()<v2.getRate()?v1:v2).get();
    }
    public static Optional<Vehicle> vehicleSelectFromOtherBranch(List<Vehicle> vehicleList, String type, String carType){
        return vehicleList.stream()
                .filter(v -> {
                            if(type=="bike"){
                                return v.getType()=="bike";
                            }
                            else if(carType=="car"){
                                return v.getCarType()== carType;
                            }
                            return false;
                        })
                .reduce((v1,v2)-> v1.getRate()<v2.getRate()?v1:v2);
    }
}
