package com.ufostyle.customerservice.config;

/*import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;*/
import org.springframework.context.annotation.Configuration;
/*import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;*/

@Configuration
public class KafkaConfig {

  /*@Bean
  public ProducerFactory producerFactory() {
    Map<String, Object> config = new HashMap<>();
    config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
    config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    return new DefaultKafkaProducerFactory<>(config);
  }

  @Bean//(name = "kafkaStringTemplate")
  public KafkaTemplate<String, CustomerKafkaMapper> kafkaTemplate() {
    return new KafkaTemplate<>(producerFactory());
  }*/
}
