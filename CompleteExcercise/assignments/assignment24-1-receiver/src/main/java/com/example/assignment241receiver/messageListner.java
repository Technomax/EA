package com.example.assignment241receiver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class messageListner {
    @JmsListener(destination = "calculatorQueue")
    public void receiveMessage(final String calculatorAsString)
    {
        try{
            ObjectMapper objectMapper=new ObjectMapper();
            Calculator calculator=objectMapper.readValue(calculatorAsString, Calculator.class);
            System.out.println("JMS receiver received message:"+calculator);
        }
        catch(JsonProcessingException ex)
        {
            ex.printStackTrace();
        }
    }
}
