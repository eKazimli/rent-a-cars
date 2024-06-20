package org.example.rentacar.database.contact.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.rentacar.database.contact.entity.cars.Car;
import org.example.rentacar.database.contact.entity.cars.Model;
import org.example.rentacar.database.contact.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/cars")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CarController {

    CarService carService;

    @PostMapping("/create")
    public ResponseEntity<?> createCar(@RequestBody Car car) {
        Car savedCar = carService.createCar(car);
        return ResponseEntity.ok(savedCar);
    }

    @PutMapping("/updateCarModelPrice/{carModel}")
    public ResponseEntity<?> updateCar(@PathVariable String carModel, @RequestBody Model model) {
        return ResponseEntity.ok(carService.updateCarPrice(model,carModel));
    }

    @DeleteMapping("/deleteCar/{carModel}")
    public ResponseEntity<?> deleteCar(@PathVariable String carModel) {
        carService.deleteCar(carModel);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/Active/{carModel}")
    public ResponseEntity<?> carActive(@PathVariable String carModel) {
        carService.carActive(carModel);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{carModel}")
    public ResponseEntity<?> findByCarModel(@PathVariable String carModel) {
        return ResponseEntity.ok(carService.findByCarModel(carModel));
    }

    @GetMapping("/{carId}")
    public ResponseEntity<?> getCarById(@PathVariable Long carId) {
        return ResponseEntity.ok(carService.findCarById(carId));
    }

    @GetMapping("/AllCarBrand")
    public ResponseEntity<List<String>> getAllCarBrand() {
        List<String> carBrand = carService.getAllCarBrand();
        return ResponseEntity.ok(carBrand);
    }

}
