package com.pblgllgs.departmentservice.controller;
/*
 *
 * @author pblgl
 * Created on 25-11-2024
 *
 */

import com.pblgllgs.departmentservice.dto.DepartmentDto;
import com.pblgllgs.departmentservice.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){
        return new ResponseEntity<>(departmentService.createDepartment(departmentDto), HttpStatus.CREATED);
    }

    @GetMapping("/{department-code}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String departmentCode){
        return new ResponseEntity<>(departmentService.getDepartment(departmentCode), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments(){
        return new ResponseEntity<>(departmentService.getAllDepartments(), HttpStatus.OK);
    }

    @PutMapping("/{department-code}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("department-code") String departmentCode ,@RequestBody DepartmentDto departmentDto){
        return new ResponseEntity<>(departmentService.updateDepartment(departmentCode,departmentDto),HttpStatus.OK);
    }

    @DeleteMapping("/{department-code}")
    public ResponseEntity<String> delete(@PathVariable("department-code") String departmentCode){
        departmentService.deleteDepartment(departmentCode);
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }
}
