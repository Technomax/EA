package com.example.assignment242sender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private String firstName;
    private String lastName;
    private String accountNo;
    private double balance;
}
