package com.example.usermicroservice.serviceImp;

import com.example.usermicroservice.dto.UserDto;
import com.example.usermicroservice.entity.User;
import com.example.usermicroservice.exception.NoDataFoundException;
import com.example.usermicroservice.mapper.IUserMapper;
import com.example.usermicroservice.repository.IUserRepository;
import com.example.usermicroservice.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;
    private final IUserMapper userMapper;
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
        if(userRepository.findById(id).isPresent())
            return userRepository.findById(id).get();
        throw new NoDataFoundException();
    }
}
