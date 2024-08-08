package com.mycompany.onetoone.controllers;

import com.mycompany.onetoone.dtos.AccountDto;
import com.mycompany.onetoone.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto) {
        AccountDto createdAccountDto = accountService.createAccount(accountDto);
        return new ResponseEntity<>(createdAccountDto, HttpStatus.CREATED);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<AccountDto> getEmployee(@PathVariable("accountId") int accountId) {
        AccountDto accountDto = accountService.getAccount(accountId);
        return new ResponseEntity<>(accountDto, HttpStatus.OK);
    }
}
