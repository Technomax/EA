package com.example.assignment242sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private JmsSender jmsSender;

    private static List<Account> accounts= new ArrayList<>();
    public AccountServiceImpl()
    {
        accounts.add(new Account("Anil","Maharjan","AC0001",100000.0));
    }

    @Override
    public Account deposit(String accountNo, double amount){
        Account account=accounts.stream().filter(x->x.getAccountNo().equals(accountNo)).findFirst().get();
        account.setBalance(account.getBalance()+amount);
        jmsSender.sendMessage(account);
        return account;
    }
}
