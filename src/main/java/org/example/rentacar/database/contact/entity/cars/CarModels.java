package org.example.rentacar.database.contact.entity.cars;

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
@Table(name = "carModels")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CarModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String carModel;

    @Column(nullable = false)
    String carYear;

    @Column(nullable = false)
    String carBanType;

    @Column(nullable = false)
    String carColor;

    @Column(nullable = false)
    String carPrice;

    @Column(nullable = false)
    String currency;

    @Column(nullable = false)
    String power;

    @Column(nullable = false)
    String initialState;

    @Column(nullable = false)
    Long isNew;

    String isAvailable;

    @CreationTimestamp
    LocalDateTime createdAt;
    @UpdateTimestamp
    LocalDateTime updatedAt;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "carModels")
    Car car;


}
