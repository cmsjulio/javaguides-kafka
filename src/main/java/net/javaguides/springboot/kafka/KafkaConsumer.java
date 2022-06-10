package net.javaguides.springboot.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

  /*
  the consume method acts as a subscriber and it's subscribed to the 'javaguides' Kafka topic;
  whenever Kafka producer send a message to the Kafka topic, this subscriber method will receive that message from it;
  there can be any numbers of subscribers;
   */

  private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

  @KafkaListener(topics = "javaguides", groupId = "myGroup") //annotation to subscribe to the topic; groupId as in app.properties;
  public void consume(String message){
    LOGGER.info(String.format("Message received -> %s", message));

  }

}
