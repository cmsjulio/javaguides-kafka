package net.javaguides.springboot.controller;

import net.javaguides.springboot.kafka.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

  private KafkaProducer kafkaProducer;

  public MessageController(KafkaProducer kafkaProducer) {
    this.kafkaProducer = kafkaProducer;
  }

  // http:localhost:8080/api/v1/kafka/publish?message=helloWorld
  @GetMapping("/publish")
  public ResponseEntity<String> publish(@RequestParam("message") String message) {
     kafkaProducer.sendMessage(message);
     return ResponseEntity.ok("Message sent to the topic.");
  }

  /*
  as per kafka documentation, we run the command below to check for messages in a given topic
  our topic name is 'javaguides'

  $ bin/kafka-console-consumer.sh --topic javaguides --from-beginning --bootstrap-server localhost:9092


   */

}
