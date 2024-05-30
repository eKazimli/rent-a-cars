package org.example.rentacar.database.contact.repository;

import org.example.rentacar.database.contact.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    Optional<Car> findByCarModels(String carModel);
}
