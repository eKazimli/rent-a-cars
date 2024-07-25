package org.example.rentacar.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.rentacar.entity.cars.Car;
import org.example.rentacar.entity.cars.Model;
import org.example.rentacar.service.CarService;
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
        carService.createCar(car);
        return ResponseEntity.ok("Car created successfully");
    }

    @PutMapping("/updateCarModelPrice/{carModel}")
    public ResponseEntity<?> updateCar(@PathVariable String carModel, @RequestBody Model model) {
        return ResponseEntity.ok(carService.updateCarPrice(model,carModel));
    }

    @DeleteMapping("/delete/{carModel}")
    public ResponseEntity<?> deleteCar(@PathVariable String carModel) {
        carService.deleteCar(carModel);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/active/{carModel}")
    public ResponseEntity<?> carActive(@PathVariable String carModel) {
        carService.carActive(carModel);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/model/{carModel}")
    public ResponseEntity<?> findByCarModel(@PathVariable String carModel) {
        return ResponseEntity.ok(carService.findByCarModel(carModel));
    }

    @GetMapping("/id/{carId}")
    public ResponseEntity<?> getCarById(@PathVariable Long carId) {
        return ResponseEntity.ok(carService.findCarById(carId));
    }

    @GetMapping("/allCarBrand")
    public ResponseEntity<List<String>> getAllCarBrand() {
        List<String> carBrand = carService.getAllCarBrand();
        return ResponseEntity.ok(carBrand);
    }

    @GetMapping("/allCarModel")
    public ResponseEntity<List<String>> getAllCarModel() {
        List<String> carModel = carService.getAllCarModel();
        return ResponseEntity.ok(carModel);
    }

}
