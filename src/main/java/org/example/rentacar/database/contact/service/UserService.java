package org.example.rentacar.database.contact.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.rentacar.database.contact.dto.UserDto;
import org.example.rentacar.database.contact.entity.users.User;
import org.example.rentacar.database.contact.mapper.UserMapper;
import org.example.rentacar.database.contact.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserService {

    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    public User create(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
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

    public void updateUserBalance(Long id, Double money) {
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

    public UserDto findUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return UserMapper.userDto(user);
    }

    public Optional<UserDto> findByUsername(String userName) {
        return userRepository.findByUsername(userName)
                .map(UserMapper::userDto);
    }

    public boolean checkPassword(String plainPassword, UserDto userDto) {
        Optional<User> user = userRepository.findById(userDto.getId());
        return user.isPresent() && user.get().getPassword().equals(plainPassword);
    }

    public UserDto findByFin(String fin) {
        User user =  userRepository.findByFin(fin)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return UserMapper.userDto(user);
    }

}
