package com.example.usermicroservice.service;

import com.example.usermicroservice.dto.BikeDto;
import com.example.usermicroservice.dto.CarDto;
import com.example.usermicroservice.dto.UserDto;
import com.example.usermicroservice.dto.VehiclesDto;
import com.example.usermicroservice.entity.User;
import com.example.usermicroservice.model.Bike;
import com.example.usermicroservice.model.Car;

import java.util.List;

public interface IUserService {
    void saveUser(UserDto userDto);
    List<User> getAllUsers();
    User getUserById(Long id);
    List<Car> getCarsByUserId(Long userId);
    List<Bike> getBikesByUserId(Long userId);
    void userExistById(Long userId);
    void saveCar(CarDto carDto);
    void saveBike(BikeDto bikeDto);
    VehiclesDto getVehiclesByUserId(Long id);
}
