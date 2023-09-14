package com.jovana.departmentservice.service;

import com.jovana.departmentservice.dto.DepartmentDto;
import com.jovana.departmentservice.entity.Department;
import com.jovana.departmentservice.mapper.DepartmentMapper;
import com.jovana.departmentservice.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    
    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;
    
    @Override
    public DepartmentDto saveDepartment (DepartmentDto departmentDto) {
        Department department = departmentMapper.departmentDtoToDepartment(departmentDto);
        return departmentMapper.departmentToDepartmentDto(departmentRepository.save(department));
    }
    
    @Override
    public DepartmentDto getDepartmentByCode (String code) {
        return departmentMapper.departmentToDepartmentDto(departmentRepository.findByCode(code).orElseThrow());
    }
}
