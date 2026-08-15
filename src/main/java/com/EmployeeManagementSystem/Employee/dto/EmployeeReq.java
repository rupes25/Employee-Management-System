package com.EmployeeManagementSystem.Employee.dto;

import com.EmployeeManagementSystem.Employee.entity.Department;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeReq {
    @NotBlank(message = "Name is required")
    @Size(min = 3,max = 50)
    @Pattern(
            regexp = "^[A-Za-z ]+$",
            message = "Name should only contain alphabets and spaces"
    )
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;


    @NotNull(message = "Department is required")
    @Enumerated(EnumType.STRING)
    private Department department;

    @NotNull(message = "Salary is required")
    @DecimalMin(value = "0.0",inclusive = false,message = "Salary must be greater than 0")
    private BigDecimal salary;
}
