package br.jan1ooo.punkapi.domain.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record AuthenticationDTO(@NotNull @NotEmpty String username,@NotNull @NotEmpty String password) {
}
