package com.fpt.fsa.spring.repositories;

import com.fpt.fsa.spring.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, String> {
    List<EmployeeEntity> findByDepartmentName(String departmentName);
}
