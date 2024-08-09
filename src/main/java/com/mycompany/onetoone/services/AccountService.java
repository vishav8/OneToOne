package com.mycompany.onetoone.services;
import com.mycompany.onetoone.dtos.AccountDto;

public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);
    AccountDto getAccount(String accNo);
}
