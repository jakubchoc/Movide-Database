package com.application.moviedatabase.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class UserDTO {

    @JsonProperty("_id")
    private long userId;

    @Email
    private String email;

    @NotBlank(message = "Fill your username")
    @NotNull(message = "Fill your password")
    @Size(min = 6, message = "Password must have at least 6 characters")
    private String password;

    @JsonProperty("isAdmin")
    private boolean admin;
}
