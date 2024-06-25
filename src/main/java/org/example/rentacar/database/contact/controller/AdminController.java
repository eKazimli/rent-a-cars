package org.example.rentacar.database.contact.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.rentacar.database.contact.dto.AdminDto;
import org.example.rentacar.database.contact.entity.users.Admin;
import org.example.rentacar.database.contact.service.AdminService;
import org.example.rentacar.database.contact.service.CarService;
import org.example.rentacar.database.contact.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/admin")
@RequiredArgsConstructor()
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AdminController {

    AdminService adminService;
    UserService userService;
    CarService carService;


    @PostMapping("/create")
    public ResponseEntity<?> createAdmin(@RequestBody AdminDto adminDto) {
        Admin savedAdmin = adminService.create(adminDto);
        return ResponseEntity.ok(savedAdmin);
    }

    @PutMapping("/active/{id}")
    public ResponseEntity<?> userActive(@PathVariable Long id) {
        adminService.Active(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAdmin(@PathVariable Long id) {
        adminService.delete(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteCarModel/{carModel}")
    public ResponseEntity<?> deleteCar(@PathVariable String carModel) {
        carService.deleteCar(carModel);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/allUsersFin")
    public ResponseEntity<List<String>> getAllUsersFin() {
        List<String> userFin = adminService.getAllUsersFin();
        return ResponseEntity.ok(userFin);
    }

    @PostMapping("/login")
    public ResponseEntity<?> AdminLogin(@RequestBody Admin admin) {
        String adminName = admin.getUsername();
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
