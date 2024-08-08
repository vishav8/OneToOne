package com.mycompany.onetoone.controllers;

import com.mycompany.onetoone.dtos.EmployeeDto;
import com.mycompany.onetoone.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto createdEmployeeDto = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(createdEmployeeDto, HttpStatus.CREATED);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("employeeId") int employeeId) {
        EmployeeDto employeeDto = employeeService.getEmployee(employeeId);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }
}
