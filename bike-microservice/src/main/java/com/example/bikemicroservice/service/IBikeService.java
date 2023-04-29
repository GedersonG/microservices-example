package com.example.bikemicroservice.service;

import com.example.bikemicroservice.dto.BikeDto;
import com.example.bikemicroservice.entity.Bike;

import java.util.List;

public interface IBikeService {
    void saveBike(BikeDto bikeDto);
    List<Bike> getAllBikes();
    Bike getBikeById(Long id);
    List<Bike> byUserId(Long userId);
}
