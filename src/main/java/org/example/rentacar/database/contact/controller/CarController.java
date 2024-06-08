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
@RequestMapping("/cars")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CarController {

    CarService carService;

    @PostMapping("/createCar")
    public ResponseEntity<?> createCar(@RequestBody Car cars) {
        Car savedCar = carService.createCar(cars);
        return ResponseEntity.ok(savedCar);
    }

    @PutMapping("/updateCarModelPrice/{carModel}")
    public ResponseEntity<?> updateCar(@PathVariable String carModel, @RequestBody Model model) {
        return ResponseEntity.ok(carService.updateCarPrice(model, carModel));
    }

    @DeleteMapping("/deleteCar/{carModel}")
    public ResponseEntity<?> deleteCar(@PathVariable String carModel) {
        carService.deleteCar(carModel);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getCar/{brand}/{carModel}")
    public ResponseEntity<?> findByBrandAndCarModel(@PathVariable String brand, @PathVariable String carModel) {
        return ResponseEntity.ok(carService.findByBrandAndCarModel(brand, carModel));
    }

    @GetMapping("/AllCarBrand")
    public ResponseEntity<List<String>> getAllCarBrand() {
        List<String> carBrand = carService.getAllCarBrand();
        return ResponseEntity.ok(carBrand);
    }

}
