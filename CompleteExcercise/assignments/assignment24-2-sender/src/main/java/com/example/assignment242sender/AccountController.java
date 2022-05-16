package com.example.assignment242sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AccountController {
    @Autowired
    private AccountServiceImpl accountServiceImpl;

    @PutMapping("/deposit/{accountNo}/{amount}")
    public ResponseEntity<Account> deposit(@PathVariable String accountNo,@PathVariable double amount){
        return new ResponseEntity<Account>(accountServiceImpl.deposit(accountNo,amount), HttpStatus.OK);
    }
}
