package com.example.usermicroservice.dto;

import com.example.usermicroservice.model.Bike;
import com.example.usermicroservice.model.Car;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class VehiclesDto {
    private List<Car> cars;
    private List<Bike> bikes;
}
