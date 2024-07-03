package org.example.rentacar.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.rentacar.dto.AdminDto;
import org.example.rentacar.entity.users.Admin;
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

}
