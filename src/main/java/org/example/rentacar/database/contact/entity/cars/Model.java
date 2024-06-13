package org.example.rentacar.database.contact.entity.cars;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "car_model")
public class Model {

    @Id
    @GeneratedValue
    Long id;

    @NotBlank(message = "Car-model must not be empty")
    @Column(unique = true)
    String carModel;

    @NotBlank(message = "Car-year must not be empty")
    String year;

    @NotBlank(message = "Car-banType must not be empty")
    String banType;

    @NotBlank(message = "Car-color must not be empty")
    String color;

    @NotBlank(message = "Car-power must not be empty")
    String power;

    @NotNull(message = "Car-price must not be empty")
    Double price;

    @NotNull(message = "Price-currency must not be empty")
    String currency;

    @NotNull
    Boolean isNew = true;

    @CreationTimestamp
    LocalDateTime createdAt;
    @UpdateTimestamp
    LocalDateTime updatedAt;

    Boolean isActive = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    Car car;
}
