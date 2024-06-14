package org.example.rentacar.database.contact.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.rentacar.database.contact.entity.users.Admin;
import org.example.rentacar.database.contact.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor()
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AdminController {

    AdminService adminService;

    @PostMapping("/createAdmin")
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
        Admin adminSave = adminService.create(admin);
        return ResponseEntity.ok(adminSave);
    }

    @PutMapping("/adminActive/{id}")
    public ResponseEntity<?> userActive(@PathVariable Long id) {
        adminService.adminActive(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteAdmin/{id}")
    public ResponseEntity<?> deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> AdminLogin(@RequestBody Admin admin) {
        String adminName = admin.getAdminName();
        String password = admin.getPassword();

        Optional<Admin> optionalAdmin = adminService.findByAdminName(adminName);
        if (optionalAdmin.isPresent()) {
            Admin adminLogin = optionalAdmin.get();
            if (adminLogin.getPassword().equals(password)) {
                // Spring Security kullanarak JWT oluşturulabilir.
                return ResponseEntity.ok("Login successful");
            }
        } else {
            return ResponseEntity.ok("Login failed");
        }
        return ResponseEntity.ok(".:Failed:.");
    }
}
