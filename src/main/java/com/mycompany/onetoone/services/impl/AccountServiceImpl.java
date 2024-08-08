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
        Account account = modelMapper.map(accountDto, Account.class);
        Account savedAccount = accountRepository.save(account);
        AccountDto savedAccountDto = modelMapper.map(savedAccount, AccountDto.class);
        return savedAccountDto;
    }

    @Override
    public AccountDto getAccount(int accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("Account not found with given id"));
        AccountDto savedAccountDto = modelMapper.map(account, AccountDto.class);
        return savedAccountDto;
    }
}
