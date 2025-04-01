package org.example.matrixmentor.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.time.LocalDate;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EmployeeDto {
    private Long id;
    @Length(min = 3, max = 15,message = "Name must be between 3 and 15")
    private String name;
    private String surName;
    @NotNull(message = "Fin must not be null")
    private Long fin;
    private int age;
    private LocalDate birthDate;
    private String phoneNumber;
    @Email(message = "Email should be valid")
    private String email;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDto that = (EmployeeDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
