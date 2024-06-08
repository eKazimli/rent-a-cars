package org.example.rentacar.database.contact.repository;

import org.example.rentacar.database.contact.entity.cars.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByBrandAndCarModel(String brand, String carModel);
}
