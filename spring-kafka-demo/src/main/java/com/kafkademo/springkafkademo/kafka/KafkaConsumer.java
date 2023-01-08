package com.kafkademo.springkafkademo.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER= LoggerFactory.getLogger(KafkaConsumer.class);
    @KafkaListener(topics = "kafkademo",groupId="myGroup")
    private void consumer(String message){

        LOGGER.info("message received  %s",message);
    }
}
