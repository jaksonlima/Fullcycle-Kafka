package com.kafka.service.impl;

import com.kafka.model.Pessoa;
import com.kafka.service.Consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerImpl implements Consumer {

  // @KafkaListener(topics = "teste", groupId = "x", topicPartitions = {
  // @TopicPartition(topic = "teste", partitions = { "0" }) })
  @KafkaListener(topics = "teste", groupId = "x")
  public void kafkaConsumer0(ConsumerRecord<String, Pessoa> obj) {
    Pessoa value = obj.value();
    System.out.println("Consumer 0: " + value + "\n");
  }

}
