package org.example.rentacar.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AdminDto {
    Long id;

    @NotBlank(message = "Cannot be empty")
    String username;

    @NotBlank(message = "Cannot be empty")
    String password;
}
