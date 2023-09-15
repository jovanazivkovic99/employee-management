package com.jovana.employeeservice.dto;

import lombok.Builder;

@Builder
public record DepartmentDto(
        Long id,
        String name,
        String description,
        String code
) {

}
