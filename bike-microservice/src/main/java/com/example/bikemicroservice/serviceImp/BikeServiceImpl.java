package com.example.bikemicroservice.serviceImp;

import com.example.bikemicroservice.dto.BikeDto;
import com.example.bikemicroservice.entity.Bike;
import com.example.bikemicroservice.exception.NoDataFoundException;
import com.example.bikemicroservice.mapper.IBikeMapper;
import com.example.bikemicroservice.repository.IBikeRepository;
import com.example.bikemicroservice.service.IBikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BikeServiceImpl implements IBikeService {

    private final IBikeRepository bikeRepository;
    private final IBikeMapper bikeMapper;
    @Override
    public void saveBike(BikeDto bikeDto) {
        Bike bike = bikeMapper.toBikeEntity(bikeDto);
        bikeRepository.save(bike);
    }

    @Override
    public List<Bike> getAllBikes() {
        if(bikeRepository.findAll().isEmpty())
            throw new NoDataFoundException();
        return bikeRepository.findAll();
    }

    @Override
    public Bike getBikeById(Long id) {
        if(bikeRepository.findById(id).isPresent())
            return bikeRepository.findById(id).get();
        throw new NoDataFoundException();
    }

    @Override
    public List<Bike> byUserId(Long userId) {
        if(bikeRepository.findByUserId(userId).isEmpty())
            throw new NoDataFoundException();
        return bikeRepository.findByUserId(userId);
    }
}
