package com.jovana.employeeservice.service;

import com.jovana.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    
    EmployeeDto getEmployeeById (Long id);
}
