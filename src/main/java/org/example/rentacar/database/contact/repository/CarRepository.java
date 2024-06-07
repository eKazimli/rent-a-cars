package org.example.rentacar.database.contact.repository;

import org.example.rentacar.database.contact.entity.cars.Car;
import org.example.rentacar.database.contact.entity.cars.CarModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByCarBrandAndCarModels(String carBrand, CarModels carModels);
    Optional<Car> findByCarModels(CarModels carModels);
}
