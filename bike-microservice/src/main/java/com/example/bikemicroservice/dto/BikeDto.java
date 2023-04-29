package com.example.bikemicroservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BikeDto {
    private String brand;
    private String model;
    private Long userId;
}
