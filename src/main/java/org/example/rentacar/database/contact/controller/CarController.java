package org.example.rentacar.database.contact.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.rentacar.database.contact.entity.cars.Car;
import org.example.rentacar.database.contact.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @PutMapping("/updateCarModelPrice/{carModels}")
    public ResponseEntity<?> updateCar(@PathVariable String carModels, @RequestBody Car car) {
        return ResponseEntity.ok(carService.updateCar(carModels, car));
    }

    @DeleteMapping("/deleteCarModel/{carModels}")
    public ResponseEntity<?> deleteCarModel(@PathVariable String carModels) {
        carService.deleteCar(carModels);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/id/{carId}")
    public ResponseEntity<?> getCarById(@PathVariable Long carId) {
        return ResponseEntity.ok(carService.findCarById(carId));
    }

    @GetMapping("/{carBrand}/{carModels}")
    public ResponseEntity<?> getCarByModel(@PathVariable String carModels, @PathVariable String carBrand) {
        List<Car> cars = carService.findByCarBrandAndCarModels(carBrand, carModels);
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/carCountByBrand")
    public ResponseEntity<Map<String, Long>> getCarCountByBrand() {
        Map<String, Long> carCountByBrand = carService.getCarCountByBrand();
        return ResponseEntity.ok(carCountByBrand);
    }


}
