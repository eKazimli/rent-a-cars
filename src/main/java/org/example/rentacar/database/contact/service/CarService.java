package org.example.rentacar.database.contact.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.rentacar.database.contact.entity.cars.Car;
import org.example.rentacar.database.contact.entity.cars.Model;
import org.example.rentacar.database.contact.repository.CarRepository;
import org.example.rentacar.database.contact.repository.ModelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)

public class CarService {

    CarRepository carRepository;
    ModelRepository modelRepository;

    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    public Model updateCarPrice(Model model, String carModel) {
        Optional<Model> optionalUpdateModelPrice = modelRepository.findByCarModel(carModel);
        Model updateModelPrice = optionalUpdateModelPrice.orElseThrow(() -> new IllegalArgumentException("Car model not found: "));
        updateModelPrice.setPrice(model.getPrice());
        return modelRepository.save(updateModelPrice);
    }

    public void deleteCar(String model) {
        var carToDelete = modelRepository.findByCarModel(model)
                .orElseThrow(() -> new RuntimeException("User type not found"));
        carToDelete.setIsActive(false);
        modelRepository.save(carToDelete);
    }

    public List<Car> findByBrandAndCarModel(String brand, String model) {
        return carRepository.findByBrandAndCarModel(brand, model);
    }

    public List<String> getAllCarBrand() {
        List<Car> cars = carRepository.findAll();
        return cars.stream()
                .map(Car::getBrand)
                .collect(Collectors.toList());
    }
}
