package com.example.bikemicroservice.repository;

import com.example.bikemicroservice.entity.Bike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBikeRepository extends JpaRepository<Bike, Long> {
    List<Bike> findByUserId(Long userId);
}
