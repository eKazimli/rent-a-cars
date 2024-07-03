package org.example.rentacar.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.rentacar.dto.AdminDto;
import org.example.rentacar.entity.users.Admin;
import org.example.rentacar.entity.users.User;
import org.example.rentacar.repository.AdminRepository;
import org.example.rentacar.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AdminService {

    AdminRepository adminRepository;
    UserRepository userRepository;

    public Admin create(AdminDto adminDto) {
        Admin admin = new Admin();
        admin.setUsername(adminDto.getUsername());
        admin.setPassword(adminDto.getPassword());
        return adminRepository.save(admin);
    }

    public void delete(Long id) {
        var adminToDelete = adminRepository.
                findById(id).
                orElseThrow(() -> new RuntimeException("Admin type not found"));
        adminToDelete.setIsActive(false);
        adminRepository.save(adminToDelete);
    }

    public void Active(Long id) {
        var adminToActive = adminRepository.
                findById(id).
                orElseThrow(() -> new RuntimeException("Admin type not found"));
        adminToActive.setIsActive(true);
        adminRepository.save(adminToActive);
    }

    public List<String> getAllUsersFin() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(User::getFin)
                .collect(Collectors.toList());
    }
}
