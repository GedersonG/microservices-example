package com.example.usermicroservice.serviceImp;

import com.example.usermicroservice.clients.ICarFeignClient;
import com.example.usermicroservice.dto.CarDto;
import com.example.usermicroservice.dto.UserDto;
import com.example.usermicroservice.entity.User;
import com.example.usermicroservice.exception.NoDataFoundException;
import com.example.usermicroservice.exception.UserDoesNotExistException;
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

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;
    private final IUserMapper userMapper;
    private final RestTemplate restTemplate;
    private final ICarMapper carMapper;
    private final ICarFeignClient carFeignClient;
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
        List<Car> cars = restTemplate.getForObject("http://localhost:8082/car/user/" + userId, List.class);
        if(cars.isEmpty())
            throw new NoDataFoundException();
        return cars;
    }

    @Override
    public List<Bike> getBikesByUserId(Long userId) {
        userExistById(userId);
        List<Bike> bikes = restTemplate.getForObject("http://localhost:8083/bike/user/" + userId, List.class);
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
        carFeignClient.save(car);
    }
}
