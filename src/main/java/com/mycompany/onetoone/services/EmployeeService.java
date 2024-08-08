package com.mycompany.onetoone.services;

import com.mycompany.onetoone.dtos.EmployeeDto;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployee(int employeeId);
}
