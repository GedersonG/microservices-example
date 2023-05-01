package com.example.usermicroservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDto {
    private String brand;
    private String model;
    private Long userId;
}
