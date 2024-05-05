package com.venkat.ksb.config;


import com.venkat.ksb.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
@Slf4j
public class KafkaConsumerConfig {

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Employee> kafkaListenerContainerFactory(
            @Value("${spring.kafka.bootstrap-servers}") String bootstrapServer,
            @Value("${spring.kafka.consumer.group-id}") String groupId,
            @Value("${spring.kafka.consumer.key-deserializer}") String keyDeserializer,
            @Value("${spring.kafka.consumer.value-deserializer}") String valueDeserializer,
            @Value("${spring.kafka.consumer.auto-offset-reset}") String autoOffsetReset
    ){

        ConcurrentKafkaListenerContainerFactory<String, Employee> factory =
                    new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory(bootstrapServer,groupId,keyDeserializer,valueDeserializer,autoOffsetReset));
        return factory;
    }

   private ConsumerFactory<String, Employee> consumerFactory(String bootstrapServer,String groupId,String keyDeserializer,
                                                             String valueDeserializer,String autoOffsetReset){
        log.info("Properties ");
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, keyDeserializer);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, valueDeserializer);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, autoOffsetReset);
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        return new DefaultKafkaConsumerFactory<>(props);

    }
}
