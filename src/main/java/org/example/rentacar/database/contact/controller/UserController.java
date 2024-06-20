package org.example.rentacar.database.contact.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.rentacar.database.contact.dto.LoginRequestDto;
import org.example.rentacar.database.contact.dto.UserDto;
import org.example.rentacar.database.contact.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("v1/users")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserController {

    UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {
        UserDto savedUser = userService.createUser(userDto);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/login")
    public ResponseEntity<?> userLogin(@RequestBody LoginRequestDto loginRequestDto) {
        Optional<UserDto> optionalUser = userService.findByUsername(loginRequestDto.getUsername());
        if (optionalUser.isPresent()) {
            UserDto userLogin = optionalUser.get();
            if (userService.checkPassword(loginRequestDto.getPassword(), userLogin)) {
                // Spring Security istifade ederek JWT
                return ResponseEntity.ok("Login successful");
            }
        } else {
            return ResponseEntity.ok("Login failed");
        }
        return ResponseEntity.status(401).body(".:Failed:.");
    }

    @PutMapping("/updateUsername/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.updateUserName(id, userDto));
    }

    @PutMapping("/active/{id}")
    public ResponseEntity<?> userActive(@PathVariable Long id) {
        userService.userActive(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/updateBalance/{id}/{replaceBalance}")
    public ResponseEntity<Void> updateBalance(@PathVariable Long id, @PathVariable Double replaceBalance) {
        userService.updateUserBalance(id, replaceBalance);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.findUserById(userId));
    }

    @GetMapping("/{fin}")
    public ResponseEntity<UserDto> findByFin(@PathVariable String fin) {
        return ResponseEntity.ok(userService.findByFin(fin));
    }

}
