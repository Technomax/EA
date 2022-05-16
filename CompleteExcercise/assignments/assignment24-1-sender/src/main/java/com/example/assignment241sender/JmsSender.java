package com.example.assignment241sender;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsSender {
    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage(Calculator result) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String calculatorString = objectMapper.writeValueAsString(result);
            System.out.println("Sending a JMS message:" + calculatorString);
            jmsTemplate.convertAndSend("calculatorQueue", calculatorString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
