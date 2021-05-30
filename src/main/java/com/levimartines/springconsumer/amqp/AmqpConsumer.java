package com.levimartines.springconsumer.amqp;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;

public interface AmqpConsumer<T> {

    void consumer(T t) throws AmqpRejectAndDontRequeueException;
}
