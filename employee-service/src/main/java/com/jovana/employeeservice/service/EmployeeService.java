package com.jovana.employeeservice.service;

import com.jovana.employeeservice.dto.APIResponseDto;
import com.jovana.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    
    APIResponseDto getEmployeeById (Long id);
}
