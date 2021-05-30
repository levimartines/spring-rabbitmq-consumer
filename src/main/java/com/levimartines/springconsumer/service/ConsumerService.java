package com.levimartines.springconsumer.service;

import com.levimartines.springconsumer.dto.Message;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    public void action(Message message) {
        System.out.println("Consumer message: " + message.getText());
    }
}
