package org.example.rentacar.database.contact.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.rentacar.database.contact.entity.Car;
import org.example.rentacar.database.contact.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CarController {

    CarService carService;

    @PostMapping("createCar")
    public ResponseEntity<?> createCar(@RequestBody Car car) {
        Car saveCar = carService.createCar(car);
        return ResponseEntity.ok(saveCar);
    }

    @GetMapping("/id/{carId}")
    public ResponseEntity<?> getCarById(@PathVariable Long carId) {
        return ResponseEntity.ok(carService.findCarById(carId));
    }

    @GetMapping("/carModels/{carModels}")
    public ResponseEntity<?> getCarByModel(@PathVariable String carModels) {
        return ResponseEntity.ok(carService.findByCarModels(carModels));
    }

}
