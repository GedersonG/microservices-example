package com.example.bikemicroservice.controller;

import com.example.bikemicroservice.dto.BikeDto;
import com.example.bikemicroservice.entity.Bike;
import com.example.bikemicroservice.service.IBikeService;
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
@RequestMapping("/bike")
@RequiredArgsConstructor
public class BikeController {

    private final IBikeService bikeService;

    @PostMapping("/")
    public ResponseEntity<Void> saveBike(@RequestBody BikeDto bikeDto){
        bikeService.saveBike(bikeDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Bike>> getAllBikes(){
        return ResponseEntity.ok(bikeService.getAllBikes());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Bike> getBikeById(@PathVariable("id") Long id){
        return ResponseEntity.ok(bikeService.getBikeById(id));
    }

    @GetMapping("/user/{user-id}")
    public ResponseEntity<List<Bike>> getBikeByUserId(@PathVariable("user-id") Long userId){
        return ResponseEntity.ok(bikeService.byUserId(userId));
    }
}
