package com.jovana.employeeservice.service;

import com.jovana.employeeservice.dto.EmployeeDto;
import com.jovana.employeeservice.entity.Employee;
import com.jovana.employeeservice.exception.EmployeeAlreadyExistsException;
import com.jovana.employeeservice.exception.ResourceNotFoundException;
import com.jovana.employeeservice.mapper.EmployeeMapper;
import com.jovana.employeeservice.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    @Override
    public EmployeeDto saveEmployee (EmployeeDto employeeDto) {
        Optional<Employee> employee =
                employeeRepository.findByEmail(employeeDto.email());
        if (employee.isPresent()) {
            throw new EmployeeAlreadyExistsException("Employee already exists.");
        }
        return employeeMapper.employeeToEmployeeDto(employeeRepository.save(employeeMapper.employeeDtoToEmployee(
                employeeDto)));
    }
    
    @Override
    public EmployeeDto getEmployeeById (Long id) {
        Employee employee = employeeRepository.findById(id)
                                              .orElseThrow(() -> new ResourceNotFoundException("Employee",
                                                                                               "id",
                                                                                               id.toString()));
        return employeeMapper.employeeToEmployeeDto(employee);
    }
}
