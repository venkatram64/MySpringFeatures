package com.venkat.plain.service.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.SecureRandom;
import java.util.Properties;

public class MyProducer {

    private static final Logger log = LoggerFactory.getLogger(MyProducer.class.getClass().getSimpleName());

    //to generate random messages
    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();
    //end of above code

    private KafkaProducer<String, String> producer;
    private String topicName = "my-test-topic";

    public MyProducer(){
        log.info("Setting properties to connect the kafka producer ");
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        //producer properties
        props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        //props.put("acks", "all"); //for acknowledgement 0, 1, all
        //retries
        //max.in.flight.requests.per.connection 1
        producer = new KafkaProducer<>(props);
    }

    public void publish(){
        //Control + p --> getting the parameters
        log.info("Publishing the message into topic ");
        ProducerRecord<String,String> producerRecord = new ProducerRecord<>(topicName, "Hello, Venkatram");
        this.producer.send(producerRecord);
        this.producer.flush();
    }

    public void publishRandomMessages(int counter){
        //Control + p --> getting the parameters
        for(int i = 0; i < counter; i++){
            String msg = generateRandomString(10);
            log.info("Publishing the message into topic ");
            ProducerRecord<String,String> producerRecord = new ProducerRecord<>(topicName, msg);
            this.producer.send(producerRecord);
        }
        this.producer.flush();
        this.producer.close();
    }

    public static String generateRandomString(int length){
        StringBuilder sb = new StringBuilder( length );
        for( int i = 0; i < length; i++ ) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        MyProducer myProducer = new MyProducer();
        //myProducer.publish();
        myProducer.publishRandomMessages(9);

    }
}
