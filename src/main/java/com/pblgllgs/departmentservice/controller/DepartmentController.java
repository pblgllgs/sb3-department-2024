package com.pblgllgs.departmentservice.controller;
/*
 *
 * @author pblgl
 * Created on 25-11-2024
 *
 */

import com.pblgllgs.departmentservice.dto.DepartmentDto;
import com.pblgllgs.departmentservice.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/departments")
@Tag(
        name = "Department controller",
        description = "Department controller exposes REST APIs for department service"
)
public class DepartmentController {

    private final DepartmentService departmentService;

    @Operation(
            summary = "Save department REST ENDPOINT",
            description = "Save department REST API is used to save department object in database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HttpStatus CREATED"
    )
    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){
        return new ResponseEntity<>(departmentService.createDepartment(departmentDto), HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get department by code REST ENDPOINT",
            description = "Get department by code REST API is used to get department object by code"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HttpStatus OK"
    )
    @GetMapping("/{department-code}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String departmentCode){
        return new ResponseEntity<>(departmentService.getDepartment(departmentCode), HttpStatus.OK);
    }

    @Operation(
            summary = "Get all departments REST ENDPOINT",
            description = "Get all departments REST API is used to get all departments in database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HttpStatus OK"
    )
    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments(){
        return new ResponseEntity<>(departmentService.getAllDepartments(), HttpStatus.OK);
    }

    @Operation(
            summary = "Update department by code REST ENDPOINT",
            description = "Update department by code REST API is used to update department object by code and save in database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HttpStatus OK"
    )
    @PutMapping("/{department-code}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("department-code") String departmentCode ,@RequestBody DepartmentDto departmentDto){
        return new ResponseEntity<>(departmentService.updateDepartment(departmentCode,departmentDto),HttpStatus.OK);
    }

    @Operation(
            summary = "Delete department by code REST ENDPOINT",
            description = "Delete department by code REST API is used to delete department object by code"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HttpStatus OK"
    )
    @DeleteMapping("/{department-code}")
    public ResponseEntity<String> delete(@PathVariable("department-code") String departmentCode){
        departmentService.deleteDepartment(departmentCode);
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }
}
