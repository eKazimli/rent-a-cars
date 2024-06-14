package org.example.rentacar.database.contact.entity.cars;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "cars")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Car {

    @Id
    @GeneratedValue
    Long id;

    @NotBlank(message = "Car-brand must not be empty")
    @Column(unique = true)
    String brand;

    @NotBlank(message = "Car-model must not be empty")
    @Column(unique = true)
    String carModel;

    @CreationTimestamp
    LocalDateTime createdAt;
    @UpdateTimestamp
    LocalDateTime updatedAt;

    Boolean isActive = true;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Model> models = new ArrayList<>();

    public void addModel(Model model) {
        models.add(model);
        model.setCar(this);
    }


}
