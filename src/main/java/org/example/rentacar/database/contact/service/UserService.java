package org.example.rentacar.database.contact.service;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.rentacar.database.contact.entity.User;
import org.example.rentacar.database.contact.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor // Constructor yazmaga ehtiyac qalmir.
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserService {

    UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
