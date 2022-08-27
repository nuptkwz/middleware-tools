package com.kwz.springboot;

import com.kwz.springboot.kafka.component.Producer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Description
 * Date 2022/4/5 11:45
 * Created by kwz
 */
@SpringBootTest
@Slf4j
public class SpringBootKafkaTest {

    @Autowired(required = false)
    private Producer kafkaProducer;

    @Test
    public void testKafka() {
        kafkaProducer.sendMessage("hello");
    }
}
