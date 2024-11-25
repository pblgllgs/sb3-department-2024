package com.pblgllgs.departmentservice.service;

import com.pblgllgs.departmentservice.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    DepartmentDto createDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartment(String departmentCode);
    List<DepartmentDto> getAllDepartments();
    DepartmentDto updateDepartment(String departmentCode,DepartmentDto departmentDto);
    void deleteDepartment(String departmentCode);
}
