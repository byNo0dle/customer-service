package com.ufostyle.customerservice.consumers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaStringConsumer {

  /*Logger logger = LoggerFactory.getLogger(KafkaStringConsumer.class);

  @KafkaListener(topics = "customer-topic" , groupId = "group_id")
  public void consume(String message) {
    logger.info("Consuming Message {}", message);
  }*/
}
