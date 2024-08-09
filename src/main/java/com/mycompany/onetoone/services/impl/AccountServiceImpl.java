package com.mycompany.onetoone.services.impl;

import com.mycompany.onetoone.dtos.AccountDto;
import com.mycompany.onetoone.dtos.EmployeeDto;
import com.mycompany.onetoone.entities.Account;
import com.mycompany.onetoone.entities.Employee;
import com.mycompany.onetoone.repositories.AccountRepository;
import com.mycompany.onetoone.services.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = new Account();
        account.setAccNo(accountDto.getAccNo());
        account.setAccType(accountDto.getAccType());
        account.setAccHolderName(accountDto.getAccHolderName());
        account.setAccBalance(accountDto.getAccBalance());
        account.setEmployee(new Employee());
        account.getEmployee().setEmployeeNo(accountDto.getEmployeeDto().getEmployeeNo());
        account.getEmployee().setEmployeeName(accountDto.getEmployeeDto().getEmployeeName());
        account.getEmployee().setEmployeeSal(accountDto.getEmployeeDto().getEmployeeSal());
        account.getEmployee().setEmployeeAddr(accountDto.getEmployeeDto().getEmployeeAddr());
        account.getEmployee().setAccount(account);
        Account savedAccount = accountRepository.save(account);
        AccountDto savedAccountDto = new AccountDto();
        savedAccountDto.setAccNo(savedAccount.getAccNo());
        savedAccountDto.setAccType(savedAccount.getAccType());
        savedAccountDto.setAccHolderName(savedAccount.getAccHolderName());
        savedAccountDto.setAccBalance(savedAccount.getAccBalance());
        savedAccountDto.setEmployeeDto(new EmployeeDto());
        savedAccountDto.getEmployeeDto().setEmployeeNo(savedAccount.getEmployee().getEmployeeNo());
        savedAccountDto.getEmployeeDto().setEmployeeName(savedAccount.getEmployee().getEmployeeName());
        savedAccountDto.getEmployeeDto().setEmployeeSal(savedAccount.getEmployee().getEmployeeSal());
        savedAccountDto.getEmployeeDto().setEmployeeAddr(savedAccount.getEmployee().getEmployeeAddr());
        return savedAccountDto;
    }

    @Override
    public AccountDto getAccount(String accNo) {
        Account account = accountRepository.findById(accNo).orElseThrow(() -> new RuntimeException("Account not found with given id"));
        AccountDto savedAccountDto = new AccountDto();
        savedAccountDto.setAccNo(account.getAccNo());
        savedAccountDto.setAccType(account.getAccType());
        savedAccountDto.setAccHolderName(account.getAccHolderName());
        savedAccountDto.setAccBalance(account.getAccBalance());
        savedAccountDto.setEmployeeDto(new EmployeeDto());
        savedAccountDto.getEmployeeDto().setEmployeeNo(account.getEmployee().getEmployeeNo());
        savedAccountDto.getEmployeeDto().setEmployeeName(account.getEmployee().getEmployeeName());
        savedAccountDto.getEmployeeDto().setEmployeeSal(account.getEmployee().getEmployeeSal());
        savedAccountDto.getEmployeeDto().setEmployeeAddr(account.getEmployee().getEmployeeAddr());
        return savedAccountDto;
    }
}
