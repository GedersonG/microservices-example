package com.example.usermicroservice.clients;

import com.example.usermicroservice.model.Car;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "car-service", url="http://localhost:8082/car/")
public interface ICarFeignClient {
    @PostMapping
    void save (@RequestBody Car car);
}
