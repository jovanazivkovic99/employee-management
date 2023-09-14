package com.jovana.departmentservice.controller;

import com.jovana.departmentservice.dto.DepartmentDto;
import com.jovana.departmentservice.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DepartmentDto saveDepartment(@RequestBody DepartmentDto departmentDto){
        return departmentService.saveDepartment(departmentDto);
    }
    
    @GetMapping("/code/{code}")
    public DepartmentDto getDepartmentByCode(@PathVariable String code){
        return departmentService.getDepartmentByCode(code);
    }
}
