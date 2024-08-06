package com.fpt.fsa.spring.middleware.request;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class EmployeeRequest {
    public enum Gender {
        MALE, FEMALE, OTHER
    }

    @NotNull(message = "First name is required")
    String firstName;

    @NotNull(message = "Last name is required")
    String lastName;

    @NotNull(message = "Gender is required")
    Gender gender;

    @NotNull(message = "Date of birth is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dateOfBirth;

    String phone;
    String address;
    String departmentName;
    String remark;
}
