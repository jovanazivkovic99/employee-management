package com.jovana.employeeservice.service;

import com.jovana.employeeservice.dto.EmployeeDto;
import com.jovana.employeeservice.entity.Employee;
import com.jovana.employeeservice.mapper.EmployeeMapper;
import com.jovana.employeeservice.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    @Override
    public EmployeeDto saveEmployee (EmployeeDto employeeDto) {
       // Employee employee = employeeMapper.employeeDtoToEmployee(employeeDto)
        Employee employee = employeeRepository.save(employeeMapper.employeeDtoToEmployee(employeeDto));
        return employeeMapper.employeeToEmployeeDto(employee);
    }
    
    @Override
    public EmployeeDto getEmployeeById (Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow();
        return employeeMapper.employeeToEmployeeDto(employee);
    }
}
