package ru.ak.springrestapp.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "person")
@ToString
@Getter
@Setter
@NoArgsConstructor
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "Not empty")
    @Size(min = 2, max = 30, message = " 2<=l<30")
    private String name;

    @Column(name = "age")
    @Min(value = 0, message = ">0")
    private int age;

    @Column(name = "email")
    @NotEmpty(message = "Not empty")
    @Email
    private String email;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "created_by")
    @NotEmpty
    private String createdBy;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
