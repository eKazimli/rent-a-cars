package org.example.rentacar.database.contact.entity.features;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.example.rentacar.database.contact.entity.users.User;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "areSelecteds")
@SQLRestriction("active = true")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AreSelected {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "selected_id")
    Long selectedId;

    @NotBlank(message = "Car-model must not be empty")
    @Column(name = "car_model", unique = true)
    String carModel;

    @NotBlank(message = "Select must not be empty")
    Boolean selected = true;

    @NotNull
    @Column(name = "created")
    LocalDateTime created;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @PrePersist
    protected void onCreate() {
        this.selected = true;
        this.created = LocalDateTime.now();
    }
}
