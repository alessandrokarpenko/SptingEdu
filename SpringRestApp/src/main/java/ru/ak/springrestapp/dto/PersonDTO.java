package ru.ak.springrestapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class PersonDTO {

    @NotEmpty(message = "Not empty")
    @Size(min = 2, max = 30, message = " 2<=l<30")
    private String name;

    @Min(value = 0, message = ">0")
    private int age;

    @NotEmpty(message = "Not empty")
    @Email
    private String email;
}
