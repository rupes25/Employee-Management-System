package com.EmployeeManagementSystem.Employee.controller;

import com.EmployeeManagementSystem.Employee.dto.EmployeeReq;
import com.EmployeeManagementSystem.Employee.dto.EmployeeRes;
import com.EmployeeManagementSystem.Employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeRes create(@RequestBody EmployeeReq req) {
        return employeeService.create(req);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.FOUND)
    public List<EmployeeRes> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public EmployeeRes findById(@PathVariable Long id) {
        return employeeService.findById(id);

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public EmployeeRes updateById(@PathVariable Long id,@RequestBody EmployeeReq req) {
        return employeeService.updateById(id,req);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Long id) {
        employeeService.deleteById(id);
    }

}
