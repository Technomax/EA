package com.example.assignment241sender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Calculator {
    private int firstNumber;
    private int secondNumber;
    private int result;
}
