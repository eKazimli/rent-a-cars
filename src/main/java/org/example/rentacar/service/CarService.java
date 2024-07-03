package org.example.rentacar.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.rentacar.entity.cars.Car;
import org.example.rentacar.entity.cars.Model;
import org.example.rentacar.repository.CarRepository;
import org.example.rentacar.repository.ModelRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        if (car.getModels() == null) {
            car.setModels(new ArrayList<>());
        }
        car.getModels().forEach(model -> model.setCar(car));
        return carRepository.save(car);
    }

    public Model updateCarPrice(Model model, String carModel) {
        Optional<Model> optionalUpdateModelPrice = modelRepository.findByCarModel(carModel);
        Model updateModelPrice = optionalUpdateModelPrice.orElseThrow(() -> new IllegalArgumentException("Car model not found: "));
        updateModelPrice.setPrice(model.getPrice());
        updateModelPrice.setCurrency(model.getCurrency());
        return modelRepository.save(updateModelPrice);
    }

    public void deleteCar(String carModel) {
        var carToDelete = modelRepository.findByCarModel(carModel)
                .orElseThrow(() -> new RuntimeException("Car type not found"));
        carToDelete.setIsActive(false);
        modelRepository.save(carToDelete);
    }

    public void carActive(String carModel) {
        var carToActive = modelRepository.findByCarModel(carModel).
                orElseThrow(() -> new RuntimeException("Car type not found"));
        carToActive.setIsActive(true);
        modelRepository.save(carToActive);
    }

    public Car findCarById(Long id) {
        return carRepository.findById(id).orElseThrow(() -> new RuntimeException("Car not found"));
    }

    public Optional<Model> findByCarModel(String carModel) {
        return modelRepository.findByCarModel(carModel);
    }

    public List<String> getAllCarBrand() {
        List<Car> cars = carRepository.findAll();
        return cars.stream()
                .map(Car::getBrand)
                .collect(Collectors.toList());
    }
}
