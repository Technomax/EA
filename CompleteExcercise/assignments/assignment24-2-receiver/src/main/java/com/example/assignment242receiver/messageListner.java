package com.example.assignment242receiver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class messageListner {
    @JmsListener(destination = "accountQueue")
    public void receiveMessage(final String accountAsString)
    {
        try{
            ObjectMapper objectMapper=new ObjectMapper();
            Account account=objectMapper.readValue(accountAsString, Account.class);
            System.out.println("JMS receiver received message:"+account);
        }
        catch(JsonProcessingException ex)
        {
            ex.printStackTrace();
        }
    }
}
