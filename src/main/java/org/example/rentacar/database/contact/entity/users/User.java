package org.example.rentacar.database.contact.entity.users;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.example.rentacar.database.contact.entity.features.AreSelected;
import org.example.rentacar.database.contact.entity.features.Comment;
import org.example.rentacar.database.contact.entity.features.Like;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank(message = "Cannot be empty")
    @Column(nullable = false, unique = true, length = 16)
    String username;

    @NotBlank(message = "Cannot be empty")
    @Column(nullable = false, length = 10)
    String password;

    @NotBlank(message = "Cannot be empty")
    @Column(nullable = false, length = 7)
    String fin;

    @NotBlank(message = "Driver's license cannot be empty")
    @Column(nullable = false, length = 8)
    String driverLicense;

    @Column(nullable = false, length = 10)
    String phone;

    @Email
    String email;

    Double balance;

    LocalDate birthDate;

    @CreationTimestamp
    LocalDateTime createdAt;
    @UpdateTimestamp
    LocalDateTime updatedAt;

    Boolean isActive = true;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Like> likes;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<AreSelected> areSelected;
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    List<Comment> comments;
}
