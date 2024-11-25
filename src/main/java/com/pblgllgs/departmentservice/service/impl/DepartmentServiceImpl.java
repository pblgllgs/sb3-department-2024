package com.pblgllgs.departmentservice.service.impl;
/*
 *
 * @author pblgl
 * Created on 25-11-2024
 *
 */

import com.pblgllgs.departmentservice.dto.DepartmentDto;
import com.pblgllgs.departmentservice.entity.Department;
import com.pblgllgs.departmentservice.exception.ResourceNotFoundException;
import com.pblgllgs.departmentservice.repository.DepartmentRepository;
import com.pblgllgs.departmentservice.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department = modelMapper.map(departmentDto, Department.class);
        Department departmentSaved = departmentRepository.save(department);
        return modelMapper.map(departmentSaved, DepartmentDto.class);
    }

    @Override
    public DepartmentDto getDepartment(String departmentCode) {
        Department department = departmentRepository
                .findByDepartmentCode(departmentCode)
                .orElseThrow(() -> new ResourceNotFoundException("DEPARTMENT NOT FOUND"));
        return modelMapper.map(department, DepartmentDto.class);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        return departmentRepository.findAll()
                .stream()
                .map(department -> modelMapper.map(department, DepartmentDto.class))
                .toList();
    }

    @Override
    public DepartmentDto updateDepartment(String departmentCode,DepartmentDto departmentDto) {
        Department department = departmentRepository
                .findByDepartmentCode(departmentCode)
                .orElseThrow(() -> new ResourceNotFoundException("DEPARTMENT NOT FOUND"));
        department.setDepartmentName(departmentDto.getDepartmentName());
        department.setDepartmentDescription(departmentDto.getDepartmentDescription());
        Department updatedDepartment = departmentRepository.save(department);
        return modelMapper.map(updatedDepartment, DepartmentDto.class);
    }

    @Override
    public void deleteDepartment(String departmentCode) {
        Department department = departmentRepository
                .findByDepartmentCode(departmentCode)
                .orElseThrow(() -> new ResourceNotFoundException("DEPARTMENT NOT FOUND"));
        departmentRepository.delete(department);
    }
}
