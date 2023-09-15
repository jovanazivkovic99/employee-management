package com.jovana.employeeservice.service;

import com.jovana.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient (url = "http://localhost:8000", value = "DEPARTMENT-SERVICE")
public interface APIClient {
    
    @GetMapping("/api/departments/code/{code}")
    DepartmentDto getDepartmentByCode (@PathVariable String code);
    
}
