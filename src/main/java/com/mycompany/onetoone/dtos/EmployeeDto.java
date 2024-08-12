package com.mycompany.onetoone.dtos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class EmployeeDto {

    private int employeeNo;
    private String employeeName;
    private float employeeSal;
    private String employeeAddr;
    @JsonManagedReference
    private AccountDto accountDto;
}
