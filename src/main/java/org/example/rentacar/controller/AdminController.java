package org.example.rentacar.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.rentacar.dto.AdminDto;
import org.example.rentacar.entity.users.Admin;
import org.example.rentacar.entity.users.User;
import org.example.rentacar.service.AdminService;
import org.example.rentacar.service.CarService;
import org.example.rentacar.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/admin")
@RequiredArgsConstructor()
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AdminController {

    AdminService adminService;

    @PostMapping("/create")
    public ResponseEntity<?> createAdmin(@RequestBody AdminDto adminDto) {
        adminService.create(adminDto);
        return ResponseEntity.ok("Admin created successfully");
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

    @GetMapping("/allUsersFin")
    public ResponseEntity<List<String>> getAllUsersFin() {
        List<String> userFin = adminService.getAllUsersFin();
        return ResponseEntity.ok(userFin);
    }

}
