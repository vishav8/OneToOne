package com.mycompany.onetoone.services.impl;

import com.mycompany.onetoone.dtos.EmployeeDto;
import com.mycompany.onetoone.entities.Account;
import com.mycompany.onetoone.entities.Employee;
import com.mycompany.onetoone.repositories.EmployeeRepository;
import com.mycompany.onetoone.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        System.out.println("********"+employeeDto.toString());
        Employee employee = modelMapper.map(employeeDto, Employee.class);

        // Since the relationship is bidirectional, set the employee reference in the account
        if (employee.getAccount() != null) {
            employee.getAccount().setEmployee(employee);
        }

        System.out.println("********"+employee.toString());
        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDto savedEmployeeDto = modelMapper.map(savedEmployee, EmployeeDto.class);
        return savedEmployeeDto;
    }

    @Override
    public EmployeeDto getEmployee(int employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee not found with given id"));
        EmployeeDto savedEmployeeDto = modelMapper.map(employee, EmployeeDto.class);
        return savedEmployeeDto;
    }
}
