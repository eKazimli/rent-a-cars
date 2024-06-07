package org.example.rentacar.database.contact.repository;

import org.example.rentacar.database.contact.entity.cars.CarModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarModelDtlRepository extends JpaRepository<CarModels, Long> {
    Optional<CarModels> findCarModelsByCarModel(String carModel);
}
