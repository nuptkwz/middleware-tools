package com.kwz.springboot.kafka.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * Description
 * Date 2022/4/5 11:40
 * Created by kwz
 */
@Component
public class Producer {

    @Value("${spring.kafka.template.default-topic}")
    private String defaultTopic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        kafkaTemplate.send(defaultTopic, message);
    }

    public void sendMessage(String key, String message) {
        kafkaTemplate.send(defaultTopic, key, message);
    }
}
