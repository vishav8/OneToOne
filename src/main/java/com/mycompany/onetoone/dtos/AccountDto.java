package com.mycompany.onetoone.dtos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class AccountDto {

    private String accNo;
    private String accHolderName;
    private String accType;
    private long accBalance;
    @JsonBackReference
    private EmployeeDto employeeDto;
}
