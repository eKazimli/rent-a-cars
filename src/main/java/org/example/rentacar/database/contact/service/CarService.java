package org.example.rentacar.database.contact.service;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.rentacar.database.contact.entity.cars.Car;
import org.example.rentacar.database.contact.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CarService {
    CarRepository carRepository;

    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    public Car updateCar(String carModels, Car car) {
        if (carModels == null || carModels.isEmpty()) {
            throw new IllegalArgumentException("Car model cannot be null or empty");
        }
        var updatedCar = carRepository.findByCarModels(carModels).
                orElseThrow(() -> new RuntimeException("Car with model " + carModels + " not found"));
        updatedCar.setCarPrice(car.getCarPrice());
        return carRepository.save(updatedCar);
    }

    public Car findCarById(Long id) {
        return carRepository.findById(id).orElseThrow(() -> new RuntimeException("Car not found"));
    }

    public List<Car> findByCarBrandAndCarModels(String carBrand, String carModels) {
        return carRepository.findByCarBrandAndCarModels(carBrand, carModels);
    }

    public Map<String, Long> getCarCountByBrand() {
        List<Car> cars = carRepository.findAll();
        return cars.stream().collect(Collectors.groupingBy(Car::getCarBrand, Collectors.counting()));
    }

}