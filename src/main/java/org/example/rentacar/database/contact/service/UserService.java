package org.example.rentacar.database.contact.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.rentacar.database.contact.entity.users.User;
import org.example.rentacar.database.contact.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserService {

    UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUserName(Long id, User user) {
        var updateUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        updateUser.setUsername(user.getUsername());
        return userRepository.save(updateUser);
    }

    public void deleteUser(Long id) {
        var userToDelete = userRepository.
                findById(id).
                orElseThrow(() -> new RuntimeException("User type not found"));
        userToDelete.setIsActive(false);
        userRepository.save(userToDelete);
    }

    public void userActive(Long id) {
        var userToActive = userRepository.
                findById(id).
                orElseThrow(() -> new RuntimeException("User type not found"));
        userToActive.setIsActive(true);
        userRepository.save(userToActive);
    }

    public void updateUserBalance(Long id, Double money) {
        var user = userRepository.
                findById(id).
                orElseThrow(() -> new RuntimeException("User type not found"));
        var balance = user.getBalance();
        var newBalance = balance + money;
        if (newBalance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        user.setBalance(newBalance);
        userRepository.save(user);
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public Optional<User> findByUsername(String userName) {
        return userRepository.findByUsername(userName);
    }

    public User findByFin(String fin) {
        return userRepository.findByFin(fin).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<String> getAllUsersFin() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(User::getFin)
                .collect(Collectors.toList());
    }
}
