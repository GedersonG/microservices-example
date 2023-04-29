package com.example.carmicroservice.controller;

import com.example.carmicroservice.dto.CarDto;
import com.example.carmicroservice.entity.Car;
import com.example.carmicroservice.service.ICarService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController {

    private final ICarService carService;

    @PostMapping("/")
    public ResponseEntity<Void> saveCar(@RequestBody CarDto carDto){
        carService.saveCar(carDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Car>> getAllCars(){
        return ResponseEntity.ok(carService.getAllCars());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable("id") Long id){
        return ResponseEntity.ok(carService.getCarById(id));
    }

    @GetMapping("/user/{user-id}")
    public ResponseEntity<List<Car>> getCarByUserId(@PathVariable("user-id") Long userId){
        return ResponseEntity.ok(carService.byUserId(userId));
    }
}
