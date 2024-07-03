package org.example.rentacar.entity.features;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.example.rentacar.entity.cars.Model;
import org.example.rentacar.entity.users.User;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "areSelecteds")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AreSelected {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long selectedId;

    @NotBlank(message = "Select must not be empty")
    Boolean selected = true;

    @NotNull
    @Column(name = "created")
    LocalDateTime created;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @JoinColumn(name = "model_id")
    Model model;

}
