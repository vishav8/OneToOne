package com.mycompany.onetoone.dtos;

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
    private EmployeeDto employeeDto;
}
