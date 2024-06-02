package org.example.rentacar.database.contact.repository;

import org.example.rentacar.database.contact.entity.cars.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByCarBrandAndCarModels(String carBrand , String carModels);
    Optional<Car> findByCarModels(String carModels);
}
