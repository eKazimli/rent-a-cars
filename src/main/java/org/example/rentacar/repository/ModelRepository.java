package org.example.rentacar.repository;

import org.example.rentacar.entity.cars.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {
    Optional<Model> findByCarModel(String carModel);
}
