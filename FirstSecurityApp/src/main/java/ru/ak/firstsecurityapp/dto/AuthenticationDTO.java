package ru.ak.firstsecurityapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class AuthenticationDTO {

    @NotEmpty(message = "not empty pls")
    @Size(min = 2, max = 100, message = ">=2 and <100")
    private String username;
    private String password;
}
