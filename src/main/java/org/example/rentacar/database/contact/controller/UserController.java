package org.example.rentacar.database.contact.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.rentacar.database.contact.entity.User;
import org.example.rentacar.database.contact.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserController {

    UserService userService;

    @PostMapping("createUser")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        User savedUser = userService.createUser(user);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("{userId}")
    public ResponseEntity<?> getUserById(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.findUserById(userId));
    }

}
