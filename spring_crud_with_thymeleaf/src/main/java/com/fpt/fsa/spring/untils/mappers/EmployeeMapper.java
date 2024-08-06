package com.fpt.fsa.spring.untils.mappers;

import com.fpt.fsa.spring.entities.EmployeeEntity;
import com.fpt.fsa.spring.middleware.request.EmployeeRequest;
import com.fpt.fsa.spring.middleware.response.EmployeeResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeEntity sourceToDestination(EmployeeRequest request);

    EmployeeResponse destinationToSource(EmployeeEntity entity);

    List<EmployeeResponse> toDtoList(List<EmployeeEntity> entities);
}
