package com.fpt.fsa.spring.middleware.response;

import com.fpt.fsa.spring.entities.EmployeeEntity;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class EmployeeResponse {
    String employeeId;
    String firstName;
    String lastName;
    EmployeeEntity.Gender gender;
    LocalDate dateOfBirth;
    String phone;
    String address;
    String departmentName;
    String remark;
}
