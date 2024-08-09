package com.mycompany.onetoone.services.impl;

import com.mycompany.onetoone.dtos.AccountDto;
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
        Employee employee = new Employee();
        employee.setEmployeeNo(employeeDto.getEmployeeNo());
        employee.setEmployeeName(employeeDto.getEmployeeName());
        employee.setEmployeeSal(employeeDto.getEmployeeSal());
        employee.setEmployeeAddr(employeeDto.getEmployeeAddr());
        employee.setAccount(new Account());
        employee.getAccount().setAccNo(employeeDto.getAccountDto().getAccNo());
        employee.getAccount().setAccType(employeeDto.getAccountDto().getAccType());
        employee.getAccount().setAccHolderName(employeeDto.getAccountDto().getAccHolderName());
        employee.getAccount().setAccBalance(employeeDto.getAccountDto().getAccBalance());

        // Since the relationship is bidirectional, set the employee reference in the account
        if (employee.getAccount() != null) {
            employee.getAccount().setEmployee(employee);
        }
        System.out.println("********"+employee.toString());

        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDto savedEmployeeDto = new EmployeeDto();
        savedEmployeeDto.setEmployeeNo(savedEmployee.getEmployeeNo());
        savedEmployeeDto.setEmployeeName(savedEmployee.getEmployeeName());
        savedEmployeeDto.setEmployeeSal(savedEmployee.getEmployeeSal());
        savedEmployeeDto.setEmployeeAddr(savedEmployee.getEmployeeAddr());
        savedEmployeeDto.setAccountDto(new AccountDto());
        savedEmployeeDto.getAccountDto().setAccNo(savedEmployee.getAccount().getAccNo());
        savedEmployeeDto.getAccountDto().setAccType(savedEmployee.getAccount().getAccType());
        savedEmployeeDto.getAccountDto().setAccHolderName(savedEmployee.getAccount().getAccHolderName());
        savedEmployeeDto.getAccountDto().setAccBalance(savedEmployee.getAccount().getAccBalance());
        return savedEmployeeDto;
    }

    @Override
    public EmployeeDto getEmployee(int employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee not found with given id"));
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeNo(employee.getEmployeeNo());
        employeeDto.setEmployeeName(employee.getEmployeeName());
        employeeDto.setEmployeeSal(employee.getEmployeeSal());
        employeeDto.setEmployeeAddr(employee.getEmployeeAddr());
        employeeDto.setAccountDto(new AccountDto());
        employeeDto.getAccountDto().setAccNo(employee.getAccount().getAccNo());
        employeeDto.getAccountDto().setAccType(employee.getAccount().getAccType());
        employeeDto.getAccountDto().setAccHolderName(employee.getAccount().getAccHolderName());
        employeeDto.getAccountDto().setAccBalance(employee.getAccount().getAccBalance());
        return employeeDto;
    }
}
