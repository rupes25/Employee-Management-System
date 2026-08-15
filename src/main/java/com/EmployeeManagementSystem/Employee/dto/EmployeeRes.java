package com.EmployeeManagementSystem.Employee.dto;

import com.EmployeeManagementSystem.Employee.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRes {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Department department;
    private BigDecimal salary;
}
