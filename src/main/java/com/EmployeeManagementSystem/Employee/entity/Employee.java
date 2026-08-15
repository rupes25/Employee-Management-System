package com.EmployeeManagementSystem.Employee.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 50) // 50 ie. max length
    private String name;

    @Column(nullable = false,unique = true,length = 50)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Department department;

    @Column(nullable = false,precision = 12,scale = 2) //precision yani total 12 digits and scale 2 ie. decimal ke baad only 2 digits
    private BigDecimal salary;


}
