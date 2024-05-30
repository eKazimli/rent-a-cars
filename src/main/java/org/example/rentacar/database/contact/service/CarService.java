package org.example.rentacar.database.contact.service;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.rentacar.database.contact.entity.Car;
import org.example.rentacar.database.contact.repository.CarRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CarService {
    CarRepository carRepository;

    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    public Car findCarById(Long id) {
        return carRepository.findById(id).orElseThrow(() -> new RuntimeException("Car not found"));
    }

    public Car findByCarModels(String carModels) {
        return carRepository.findByCarModels(carModels).orElseThrow(() -> new RuntimeException("Car not found"));
    }
}