package com.et.ms.metrics.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class KafkaMessageProducer {
    private static final Logger logger =
            LoggerFactory.getLogger(KafkaMessageProducer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message)
    {
        this.kafkaTemplate.send("etms.dontrades", message);
        logger.info(String.format("Message sent -> %s", message));
    }

}
