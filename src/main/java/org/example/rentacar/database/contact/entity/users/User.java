package org.example.rentacar.database.contact.entity.users;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, unique = true, length = 16)
    String username;

    @Column(nullable = false, length = 10)
    String password;

    @Column(nullable = false, length = 7)
    String fin;

    @Column(nullable = false, length = 8)
    String driverLicense;

    @Column(nullable = false, length = 10)
    String phone;

    Double balance;

    String email;
    LocalDate birthDate;

    @CreationTimestamp
    LocalDateTime createdAt;
    @UpdateTimestamp
    LocalDateTime updatedAt;

    Boolean isActive = true;

}
