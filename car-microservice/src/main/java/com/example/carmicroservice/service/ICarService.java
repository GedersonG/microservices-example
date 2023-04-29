package com.example.carmicroservice.service;

import com.example.carmicroservice.dto.CarDto;
import com.example.carmicroservice.entity.Car;

import java.util.List;

public interface ICarService {
    void saveCar(CarDto carDto);
    List<Car> getAllCars();
    Car getCarById(Long id);
    List<Car> byUserId(Long userId);
}
