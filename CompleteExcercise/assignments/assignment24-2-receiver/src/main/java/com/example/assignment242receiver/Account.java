package com.example.assignment242receiver;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private String firstName;
    private String lastName;
    private String accountNo;
    private double balance;
}
