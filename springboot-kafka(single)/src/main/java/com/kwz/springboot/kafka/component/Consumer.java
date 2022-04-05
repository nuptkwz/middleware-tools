package com.kwz.springboot.kafka.component;import lombok.extern.slf4j.Slf4j;import org.apache.kafka.clients.consumer.ConsumerRecord;import org.springframework.beans.factory.annotation.Value;import org.springframework.kafka.annotation.KafkaListener;import org.springframework.stereotype.Component;/** * Description * Date 2022/4/5 11:40 * Created by kwz */@Component@Slf4jpublic class Consumer {    @KafkaListener(topics = "kwz_1")    public void listener(ConsumerRecord<String, String> record) {        String value = record.value();        log.info("【receive】:{}", value);    }}