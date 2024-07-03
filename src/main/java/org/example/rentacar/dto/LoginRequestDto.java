package org.example.rentacar.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginRequestDto {

    @NotBlank(message = "Cannot be empty")
    @Column(nullable = false, unique = true, length = 16)
    String username;

    @NotBlank(message = "Cannot be empty")
    @Column(nullable = false, length = 10)
    String password;

}
