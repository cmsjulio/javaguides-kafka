package net.javaguides.springboot.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

  @Bean
  public NewTopic javaguidesTopic(){
    return TopicBuilder.name("javaguides")
      .build();
  }

  /*
  we must create a new topic as the previous consumer would be expecting a String message, rather than a Json one.
   */
  @Bean
  public NewTopic javaguidesJsonTopic(){
    return TopicBuilder.name("javaguides_json")
      .build();
  }
}
