package com.fpt.fsa.spring.services.impl;

import com.fpt.fsa.spring.entities.EmployeeEntity;
import com.fpt.fsa.spring.exceptions.ResourceNotFoundException;
import com.fpt.fsa.spring.middleware.request.EmployeeRequest;
import com.fpt.fsa.spring.middleware.response.EmployeeResponse;
import com.fpt.fsa.spring.repositories.EmployeeRepository;
import com.fpt.fsa.spring.services.EmployeeService;
import com.fpt.fsa.spring.untils.mappers.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeResponse> getAllEmployees() {
        System.out.println(employeeMapper.toDtoList(employeeRepository.findAll()));
        return employeeMapper.toDtoList(employeeRepository.findAll());
    }

    @Override
    public EmployeeResponse getEmployeeById(String id) {
        EmployeeEntity employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
        return employeeMapper.destinationToSource(employee);
    }

    @Override
    public EmployeeResponse saveEmployee(EmployeeRequest employeeDTO) {
        System.out.println("EmployeeDTO: " + employeeDTO);
        EmployeeEntity employee = employeeMapper.sourceToDestination(employeeDTO);
        System.out.println("EmployeeEntity: " + employee.getFirstName());
        EmployeeEntity savedEmployee = employeeRepository.save(employee);
        return employeeMapper.destinationToSource(savedEmployee);
    }

    @Override
    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }
}
