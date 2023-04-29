package com.example.carmicroservice.serviceImp;

import com.example.carmicroservice.dto.CarDto;
import com.example.carmicroservice.entity.Car;
import com.example.carmicroservice.exception.NoDataFoundException;
import com.example.carmicroservice.mapper.ICarMapper;
import com.example.carmicroservice.repository.ICarRepository;
import com.example.carmicroservice.service.ICarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CarServiceImpl implements ICarService {

    private final ICarRepository carRepository;
    private final ICarMapper carMapper;
    @Override
    public void saveCar(CarDto carDto) {
        Car car = carMapper.toCarEntity(carDto);
        carRepository.save(car);
    }

    @Override
    public List<Car> getAllCars() {
        if(carRepository.findAll().isEmpty())
            throw new NoDataFoundException();
        return carRepository.findAll();
    }

    @Override
    public Car getCarById(Long id) {
        if(carRepository.findById(id).isPresent())
            return carRepository.findById(id).get();
        throw new NoDataFoundException();
    }

    @Override
    public List<Car> byUserId(Long userId) {
        if(carRepository.findByUserId(userId).isEmpty())
            throw new NoDataFoundException();
        return carRepository.findByUserId(userId);
    }
}
