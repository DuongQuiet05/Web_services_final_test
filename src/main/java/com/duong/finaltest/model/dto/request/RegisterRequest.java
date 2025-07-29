package com.duong.finaltest.model.dto.request;

import com.duong.finaltest.validate.ValidUsername;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RegisterRequest {
    @NotBlank(message = "username cannot be blank!")
    @ValidUsername(message = "username already exist!")
    private String username;

    @NotBlank(message = "fullname cannot be blank!")
    private String fullName;

    @NotBlank(message = "password cannot be blank!")
    private String password;

    @NotBlank(message = "email cannot be blank!")
    private String email;

    @NotBlank(message = "phone cannot be blank!")
    private String phone;

    private Boolean isLogin = false;

    private Boolean status = true;
}
