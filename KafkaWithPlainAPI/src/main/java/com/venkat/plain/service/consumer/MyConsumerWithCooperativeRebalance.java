package com.venkat.plain.service.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.CooperativeStickyAssignor;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class MyConsumerWithCooperativeRebalance {
    private static final Logger log = LoggerFactory.getLogger(MyConsumerWithCooperativeRebalance.class.getClass().getSimpleName());

    private KafkaConsumer<String, String> consumer;
    private String topicName = "my-test-topic";
    private String groupId = "my_test_group_id";

    public MyConsumerWithCooperativeRebalance(){
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
        //for re-balance
        props.put("partition.assignment.strategy", CooperativeStickyAssignor.class.getName());
        //props.put("group.instance.id", "..."); strategy for static assignment
        consumer = new KafkaConsumer<>(props);
    }

    public void consumer(){
        //get a reference to the main thread
        Thread mainThread = Thread.currentThread();
        //adding a shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(){
            public void run(){
                log.info("Detected a shutdown, let's exit by calling consumer.wakeup()...");
                consumer.wakeup();

                //join the main thread to allow the execution of the code in the main thread
                try {
                    mainThread.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        try {
            //Control + p --> getting the parameters
            log.info("Consuming the message from topic ");
            //subscribe to topic
            consumer.subscribe(Arrays.asList(topicName));
            //poll for data
            while (true) {
                //log.info("polling...");
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
                for (ConsumerRecord<String, String> record : records) {
                    log.info("Key: {}, Value: {}", record.key(), record.value());
                    log.info("Partition: {}, Offset: {}", record.partition(), record.offset());
                }
            }
        }catch (WakeupException w){
            log.info("Consumer is starting to shut down");
        }catch (Exception e){
            log.error("Unexpected exception in the consumer {} ", e);
        }finally {
            //close the consumer, this will also commit the offsets
            consumer.close();
            log.info("The consumer is gracefully shutdown...");
        }
    }

    public static void main(String[] args) {
        MyConsumerWithCooperativeRebalance myConsumer = new MyConsumerWithCooperativeRebalance();
        myConsumer.consumer();

    }
}
