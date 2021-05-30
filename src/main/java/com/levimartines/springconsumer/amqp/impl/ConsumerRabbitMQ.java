package com.levimartines.springconsumer.amqp.impl;

import com.levimartines.springconsumer.amqp.AmqpConsumer;
import com.levimartines.springconsumer.dto.Message;
import com.levimartines.springconsumer.service.ConsumerService;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerRabbitMQ implements AmqpConsumer<Message> {

    private final ConsumerService service;

    public ConsumerRabbitMQ(ConsumerService service) {
        this.service = service;
    }

    @Override
    @RabbitListener(queues = "${spring.rabbitmq.request.routing-key.producer}")
    public void consumer(Message message) throws AmqpRejectAndDontRequeueException {
        try {
            service.action(message);
        } catch (Exception e) {
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }
}
