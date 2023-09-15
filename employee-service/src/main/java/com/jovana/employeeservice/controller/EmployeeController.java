package com.jovana.employeeservice.controller;

import com.jovana.employeeservice.dto.APIResponseDto;
import com.jovana.employeeservice.dto.EmployeeDto;
import com.jovana.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {
    
    private final EmployeeService employeeService;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDto saveEmployee (@RequestBody EmployeeDto employeeDto) {
        return employeeService.saveEmployee(employeeDto);
    }
    
    @GetMapping("/{id}")
    public APIResponseDto getEmployeeById (@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }
}
