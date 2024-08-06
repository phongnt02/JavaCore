package com.fpt.fsa.spring.services;

import com.fpt.fsa.spring.entities.EmployeeEntity;
import com.fpt.fsa.spring.middleware.request.EmployeeRequest;
import com.fpt.fsa.spring.middleware.response.EmployeeResponse;

import java.util.List;

public interface EmployeeService {
    List<EmployeeResponse> getAllEmployees();
    EmployeeResponse getEmployeeById(String id);
    EmployeeResponse saveEmployee(EmployeeRequest employeeDTO);
    void deleteEmployee(String id);
}

