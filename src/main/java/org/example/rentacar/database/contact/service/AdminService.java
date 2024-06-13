package org.example.rentacar.database.contact.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.rentacar.database.contact.entity.users.Admin;
import org.example.rentacar.database.contact.repository.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AdminService {

    AdminRepository adminRepository;

    public Optional<Admin> findByAdminName(String adminName) {
        return adminRepository.findByAdminName(adminName);
    }

    public Admin create(Admin admin) {
        return adminRepository.save(admin);
    }
}
