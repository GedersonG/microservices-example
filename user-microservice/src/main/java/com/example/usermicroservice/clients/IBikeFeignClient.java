package com.example.usermicroservice.clients;

import com.example.usermicroservice.model.Bike;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "bike-microservice", path = "/bike")
public interface IBikeFeignClient {
    @PostMapping
    void saveBike (@RequestBody Bike bike);

    @GetMapping("/user/{userid}")
    List<Bike> bikesListByUserId (@PathVariable("userid") Long userId);
}
