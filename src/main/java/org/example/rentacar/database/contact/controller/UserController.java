package org.example.rentacar.database.contact.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.rentacar.database.contact.entity.users.User;
import org.example.rentacar.database.contact.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserController {

    UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        User savedUser = userService.createUser(user);
        return ResponseEntity.ok(savedUser);
    }

    @PutMapping("/updateUsername/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User user) {
        return ResponseEntity.ok(userService.updateUserName(id, user));
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/id/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.findUserById(userId));
    }

    @GetMapping("/fin/{fin}")
    public ResponseEntity<?> findByFin(@PathVariable String fin) {
        return ResponseEntity.ok(userService.findByFin(fin));
    }

    @GetMapping("/AllUsersFin")
    public ResponseEntity<List<String>> getAllUsersFin() {
        List<String> userFin = userService.getAllUsersFin();
        return ResponseEntity.ok(userFin);
    }

}
