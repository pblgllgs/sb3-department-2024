package com.pblgllgs.departmentservice.entity;
/*
 *
 * @author pblgl
 * Created on 25-11-2024
 *
 */

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "departments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "department_name")
    private String departmentName;
    @Column(nullable = false, name = "department_description")
    private String departmentDescription;
    @Column(nullable = false, name = "department_code", unique = true)
    private String departmentCode;
}
