package com.example.carmicroservice.repository;

import com.example.carmicroservice.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICarRepository extends JpaRepository<Car, Long> {
    List<Car> findByUserId(Long userId);
}
