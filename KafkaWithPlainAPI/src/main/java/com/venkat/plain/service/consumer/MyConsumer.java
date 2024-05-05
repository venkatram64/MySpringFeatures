package com.venkat.plain.service.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class MyConsumer {
    private static final Logger log = LoggerFactory.getLogger(MyConsumer.class.getClass().getSimpleName());

    private KafkaConsumer<String, String> consumer;
    private String topicName = "my-test-topic";
    private String groupId = "my_test_group_id";

    public MyConsumer(){
        log.info("Setting properties to connect the kafka consumer ");
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        //consumer properties
        //props.put("key.serializer","org.apache.kafka.common.serialization.StringDeserializer");
        //props.put("value.serializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("key.deserializer", StringDeserializer.class.getName());
        props.put("value.deserializer", StringDeserializer.class.getName());
        props.put("group.id", groupId);
        //none/earliest, latest
        props.put("auto.offset.reset", "earliest");
        consumer = new KafkaConsumer<>(props);
    }

    public void consumer(){
        //Control + p --> getting the parameters
        log.info("Consuming the message from topic ");
        //subscribe to topic
        consumer.subscribe(Arrays.asList(topicName));
        //poll for data
        while(true){
            log.info("polling...");
            ConsumerRecords<String, String>  records = consumer.poll(Duration.ofMillis(1000));
            for(ConsumerRecord<String, String> record: records){
                log.info("Key: {}, Value: {}", record.key(), record.value());
                log.info("Partition: {}, Offset: {}", record.partition(), record.offset());
            }
        }
    }

    public static void main(String[] args) {
        MyConsumer myConsumer = new MyConsumer();
        myConsumer.consumer();

    }
}
