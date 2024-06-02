package org.example.rentacar.database.contact.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.rentacar.database.contact.entity.users.User;
import org.example.rentacar.database.contact.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User findByFin(String fin) {
        return userRepository.findByFin(fin).orElseThrow(() -> new RuntimeException("Car not found"));
    }

    public List<String> getAllUsersFin() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(User::getFin)
                .collect(Collectors.toList());
    }
}
