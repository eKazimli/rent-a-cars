package org.example.rentacar.database.contact.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDto {
    Long id;

    @NotBlank(message = "Cannot be empty")
    String username;

    @Email
    String email;

    @Column(nullable = false, length = 10)
    String phone;
    LocalDate birthDate;
    LocalDateTime createdAt;

}
