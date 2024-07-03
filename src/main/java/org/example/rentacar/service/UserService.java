package org.example.rentacar.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.rentacar.dto.UserDto;
import org.example.rentacar.entity.users.User;
import org.example.rentacar.mapper.UserMapper;
import org.example.rentacar.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserService {

    UserRepository userRepository;

    public User create(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        return userRepository.save(user);
    }

    public UserDto updateUserName(Long id, UserDto userDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setUsername(userDto.getUsername());
        User updateUser = userRepository.save(user);
        return UserMapper.userDto(updateUser);
    }

    public void deleteUser(Long id) {
        User user = userRepository.
                findById(id).
                orElseThrow(() -> new RuntimeException("User type not found"));
        user.setIsActive(false);
        userRepository.save(user);
    }

    public void userActive(Long id) {
        User user = userRepository.
                findById(id).
                orElseThrow(() -> new RuntimeException("User type not found"));
        user.setIsActive(true);
        userRepository.save(user);
    }

    public void increaseBalance(Long id, Double money) {
        User user = userRepository.
                findById(id).
                orElseThrow(() -> new RuntimeException("User not found"));
        var newBalance = user.getBalance() + money;
        if (newBalance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        user.setBalance(newBalance);
        userRepository.save(user);
    }

    public void reduceBalance(Long id, Double money) {
        User user = userRepository.
                findById(id).
                orElseThrow(() -> new RuntimeException("User not found"));
        var newBalance = user.getBalance() - money;
        if (newBalance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        user.setBalance(newBalance);
        userRepository.save(user);
    }

    public UserDto findUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return UserMapper.userDto(user);
    }

    public UserDto findByFin(String fin) {
        User user =  userRepository.findUserByFin(fin)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return UserMapper.userDto(user);
    }

}
