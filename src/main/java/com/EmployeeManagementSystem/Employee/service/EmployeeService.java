package com.EmployeeManagementSystem.Employee.service;

import com.EmployeeManagementSystem.Employee.dto.EmployeeReq;
import com.EmployeeManagementSystem.Employee.dto.EmployeeRes;
import com.EmployeeManagementSystem.Employee.entity.Employee;

import java.util.List;

public interface EmployeeService {
    //create
    EmployeeRes create(EmployeeReq req);

    //read
    List<EmployeeRes>findAll();

    EmployeeRes findById(Long id);

    //update
    EmployeeRes updateById(Long id,EmployeeReq req);

    //delete
    void deleteById(Long id);

}
