package com.example.usermicroservice.clients;

import com.example.usermicroservice.model.Car;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "car-service", url="http://localhost:8082/car")
public interface ICarFeignClient {
    @PostMapping
    void saveCar (@RequestBody Car car);

    @GetMapping("/user/{userid}")
    List<Car> carsListByUserId (@PathVariable("userid") Long userId);
}
