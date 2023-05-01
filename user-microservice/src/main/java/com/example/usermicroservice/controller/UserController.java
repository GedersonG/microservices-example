package com.example.usermicroservice.controller;

import com.example.usermicroservice.dto.CarDto;
import com.example.usermicroservice.dto.UserDto;
import com.example.usermicroservice.entity.User;
import com.example.usermicroservice.model.Bike;
import com.example.usermicroservice.model.Car;
import com.example.usermicroservice.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @PostMapping("/")
    public ResponseEntity<Void> saveUser(@RequestBody UserDto userDto){
        userService.saveUser(userDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("/cars/{userid}")
    public ResponseEntity<List<Car>> getCarsByUserId(@PathVariable("userid") Long userId){
        return ResponseEntity.ok(userService.getCarsByUserId(userId));
    }

    @GetMapping("/bikes/{userid}")
    public ResponseEntity<List<Bike>> getBikesByUserId(@PathVariable("userid") Long userId){
        return ResponseEntity.ok(userService.getBikesByUserId(userId));
    }

    @PostMapping("/savecar")
    public ResponseEntity<Void> saveCar(@RequestBody CarDto carDto){
        userService.saveCar(carDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
