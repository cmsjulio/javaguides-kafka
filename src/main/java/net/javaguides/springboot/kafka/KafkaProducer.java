package net.javaguides.springboot.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

  /*
  to send a message to a topic, we use Spring provided Kafka template
  we just need to inject and use it
   */

  /*
  we can use a logger to log the messages
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

  private KafkaTemplate<String, String> kafkaTemplate;

  // constructor based dependency injection
  public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void sendMessage(String message) {
    LOGGER.info(String.format("Message sent: %s", message));
    kafkaTemplate.send("javaguides", message);
    // javaguides is the name of the topic we've created;
  }
}
