package com.example.assignment241sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
public class CalculatorController {
    @Autowired
    private CalculatorServiceImpl calculatorServiceImpl;

    @PostMapping("/calculators")
    public ResponseEntity<Calculator> calculators(@RequestBody Calculator calculator){
        return new ResponseEntity<Calculator>(calculatorServiceImpl.addition(calculator), HttpStatus.OK);
    }
}
