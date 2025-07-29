package com.duong.finaltest.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class LoginRequest {
    @NotBlank(message = "username cannot be blank!")
    private String username;

    @NotBlank(message = "password cannot be blank!")
    private String password;
}
