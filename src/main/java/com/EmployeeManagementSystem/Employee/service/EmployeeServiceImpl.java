package com.EmployeeManagementSystem.Employee.service;

import com.EmployeeManagementSystem.Employee.dto.EmployeeReq;
import com.EmployeeManagementSystem.Employee.dto.EmployeeRes;
import com.EmployeeManagementSystem.Employee.entity.Employee;
import com.EmployeeManagementSystem.Employee.exception.ResourceNotFoundException;
import com.EmployeeManagementSystem.Employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository repository;

    @Override
    public EmployeeRes create(EmployeeReq req) {
        Employee employee = new Employee();
        employee.setName(req.getName());
        employee.setEmail(req.getEmail());
        employee.setPassword(req.getPassword());
        employee.setDepartment(req.getDepartment());
        employee.setSalary(req.getSalary());

        Employee saved = repository.save(employee);

        return mapToDto(saved);

    }

    @Override
    public List<EmployeeRes> findAll() {
        return repository.findAll()
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public EmployeeRes findById(Long id) {
        Employee employee = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No employee found"));
        return mapToDto(employee);

    }

    @Override
    public EmployeeRes updateById(Long id, EmployeeReq req) {
        Employee employee = repository.findById(id).orElseThrow(()->new ResourceNotFoundException("No user found"));
        employee.setName(req.getName());
        employee.setEmail(req.getEmail());
        employee.setPassword(req.getPassword());
        employee.setDepartment(req.getDepartment());
        employee.setSalary(req.getSalary());

        return mapToDto(employee);

    }

    @Override
    public void deleteById(Long id) {
        Employee employee = repository.findById(id).orElseThrow(()->new ResourceNotFoundException("No user found"));
        repository.delete(employee);

    }

    public EmployeeRes mapToDto(Employee employee){
        return new EmployeeRes(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getPassword(),
                employee.getDepartment(),
                employee.getSalary()
        );
    }
}
