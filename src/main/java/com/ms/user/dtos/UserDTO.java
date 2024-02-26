package com.ms.user.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.NonNull;

public record UserDTO(@NonNull @NotBlank String name,
                      @NonNull @NotBlank @Email String email) {
}
