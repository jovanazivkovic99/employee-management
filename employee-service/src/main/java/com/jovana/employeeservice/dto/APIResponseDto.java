package com.jovana.employeeservice.dto;

import lombok.Builder;

@Builder
public record APIResponseDto(EmployeeDto employeeDto,
                             DepartmentDto departmentDto) {
    
}
