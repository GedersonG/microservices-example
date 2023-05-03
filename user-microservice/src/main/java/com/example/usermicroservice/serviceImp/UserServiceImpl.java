package com.example.usermicroservice.serviceImp;

import com.example.usermicroservice.clients.IBikeFeignClient;
import com.example.usermicroservice.clients.ICarFeignClient;
import com.example.usermicroservice.dto.BikeDto;
import com.example.usermicroservice.dto.CarDto;
import com.example.usermicroservice.dto.UserDto;
import com.example.usermicroservice.dto.VehiclesDto;
import com.example.usermicroservice.entity.User;
import com.example.usermicroservice.exception.NoDataFoundException;
import com.example.usermicroservice.exception.UserDoesNotExistException;
import com.example.usermicroservice.mapper.IBikeMapper;
import com.example.usermicroservice.mapper.ICarMapper;
import com.example.usermicroservice.mapper.IUserMapper;
import com.example.usermicroservice.model.Bike;
import com.example.usermicroservice.model.Car;
import com.example.usermicroservice.repository.IUserRepository;
import com.example.usermicroservice.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;
    private final IUserMapper userMapper;
    private final ICarMapper carMapper;
    private final IBikeMapper bikeMapper;
    private final RestTemplate restTemplate;
    private final ICarFeignClient carFeignClient;
    private final IBikeFeignClient bikeFeignClient;
    @Override
    public void saveUser(UserDto userDto) {
        User user = userMapper.toUserEntity(userDto);
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        if(userRepository.findAll().isEmpty())
            throw new NoDataFoundException();
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        userExistById(id);
        return userRepository.findById(id).get();
    }

    @Override
    public List<Car> getCarsByUserId(Long userId) {
        userExistById(userId);
        List<Car> cars = restTemplate.getForObject("http://car-microservice:8082/car/user/" + userId, List.class);
        if(cars.isEmpty())
            throw new NoDataFoundException();
        return cars;
    }

    @Override
    public List<Bike> getBikesByUserId(Long userId) {
        userExistById(userId);
        List<Bike> bikes = restTemplate.getForObject("http://bike-microservice:8083/bike/user/" + userId, List.class);
        if(bikes.isEmpty())
            throw new NoDataFoundException();
        return bikes;
    }

    @Override
    public void userExistById(Long userId) {
        if(!userRepository.existsById(userId))
            throw new UserDoesNotExistException();
    }

    @Override
    public void saveCar(CarDto carDto) {
        Car car = carMapper.toCarModel(carDto);
        carFeignClient.saveCar(car);
    }

    @Override
    public void saveBike(BikeDto bikeDto) {
        Bike bike = bikeMapper.toBikeModel(bikeDto);
        bikeFeignClient.saveBike(bike);
    }

    @Override
    public VehiclesDto getVehiclesByUserId(Long userId) {
        // Method get all vehicles (list bikes, cars)
        userExistById(userId);
        List<Car> cars = carFeignClient.carsListByUserId(userId);
        List<Bike> bikes = bikeFeignClient.bikesListByUserId(userId);
        return new VehiclesDto(cars,bikes);
    }
}
