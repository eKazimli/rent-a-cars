package org.example.rentacar.database.contact.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "cars")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String carBrand;

    @Column(nullable = false)
    String carModels;

    @Column(nullable = false)
    String carColor;

    @Column(nullable = false)
    Integer carPrice;

    String carYear;
    String carBanType;
    String currency;

    @CreationTimestamp
    LocalDateTime createdAt;
    @UpdateTimestamp
    LocalDateTime updatedAt;

    Boolean isAvailable = true;

}
