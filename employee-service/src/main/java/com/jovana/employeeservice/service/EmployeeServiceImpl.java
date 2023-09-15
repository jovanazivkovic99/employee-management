package com.jovana.employeeservice.service;

import com.jovana.employeeservice.dto.APIResponseDto;
import com.jovana.employeeservice.dto.DepartmentDto;
import com.jovana.employeeservice.dto.EmployeeDto;
import com.jovana.employeeservice.entity.Employee;
import com.jovana.employeeservice.exception.EmployeeAlreadyExistsException;
import com.jovana.employeeservice.exception.ResourceNotFoundException;
import com.jovana.employeeservice.mapper.EmployeeMapper;
import com.jovana.employeeservice.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    // private final RestTemplate restTemplate;
    //private final WebClient webClient;
    private final APIClient apiClient;
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
    public APIResponseDto getEmployeeById (Long id) {
        Employee employee = employeeRepository.findById(id)
                                              .orElseThrow(() -> new ResourceNotFoundException("Employee",
                                                                                               "id",
                                                                                               id.toString()));
      /*  ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity(
                "http://localhost:8000/api/departments/code/" + employee.getDepartmentCode(),
                DepartmentDto.class);
        DepartmentDto departmentDto = responseEntity.getBody();*/
        /*DepartmentDto departmentDto = webClient.get()
                                               .uri("http://localhost:8000/api/departments/code/" + employee.getDepartmentCode())
                                               .retrieve()
                                               .bodyToMono(DepartmentDto.class)
                                               .block();*/
        DepartmentDto departmentDto = apiClient.getDepartmentByCode(employee.getDepartmentCode());
        
        EmployeeDto employeeDto = employeeMapper.employeeToEmployeeDto(employee);
        return APIResponseDto.builder()
                             .employeeDto(employeeDto)
                             .departmentDto(departmentDto)
                             .build();
    }
}
