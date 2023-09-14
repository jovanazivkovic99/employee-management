package com.jovana.departmentservice.mapper;

import com.jovana.departmentservice.dto.DepartmentDto;
import com.jovana.departmentservice.entity.Department;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface DepartmentMapper {
    DepartmentDto departmentToDepartmentDto(Department department);
    Department departmentDtoToDepartment(DepartmentDto departmentDto);
}
