package com.example.assignment242sender;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsSender {
    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage(Account result) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String accountString = objectMapper.writeValueAsString(result);
            System.out.println("Sending a JMS message:" + accountString);
            jmsTemplate.convertAndSend("accountQueue", accountString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
