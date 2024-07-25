package org.example.rentacar.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.rentacar.dto.UserDto;
import org.example.rentacar.entity.users.User;
import org.example.rentacar.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/users")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserController {

    UserService userService;

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        userService.create(user);
        return ResponseEntity.ok("User created successfully");
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
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/increaseBalance/{id}/{replaceBalance}")
    public ResponseEntity<?> increaseBalance(@PathVariable Long id, @PathVariable Double replaceBalance) {
        userService.increaseBalance(id, replaceBalance);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/reduceBalance/{id}/{replaceBalance}")
    public ResponseEntity<?> reduceBalance(@PathVariable Long id, @PathVariable Double replaceBalance) {
        userService.reduceBalance(id, replaceBalance);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.findUserById(userId));
    }

    @GetMapping("/fin/{fin}")
    public ResponseEntity<UserDto> findByFin(@PathVariable String fin) {
        return ResponseEntity.ok(userService.findByFin(fin));
    }

}
