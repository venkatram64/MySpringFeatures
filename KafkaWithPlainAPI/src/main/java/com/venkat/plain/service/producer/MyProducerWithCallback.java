package com.venkat.plain.service.producer;

import org.apache.kafka.clients.producer.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.SecureRandom;
import java.util.Properties;

public class MyProducerWithCallback {

    private static final Logger log = LoggerFactory.getLogger(MyProducerWithCallback.class.getClass().getSimpleName());

    //to generate random messages
    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();
    //end of above code

    private KafkaProducer<String, String> producer;
    private String topicName = "my-test-topic";

    public MyProducerWithCallback(){
        log.info("Setting properties to connect the kafka producer ");
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        //producer properties
        props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        //props.put("acks", "all"); //for acknowledgement 0, 1, all
        //retries
        //max.in.flight.requests.per.connection 1
        //batch size, will send it to different partitions, do not use in production
        props.put("batch.size", 200);
        //do not use in production
        props.put("partitioner.class", RoundRobinPartitioner.class.getName());
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
        //sticky partition, publishing same message into same partitioner
        for(int i = 0; i < counter; i++){
            String msg = generateRandomString(10);
            log.info("Publishing the message into topic ");
            ProducerRecord<String,String> producerRecord = new ProducerRecord<>(topicName, msg);
            this.producer.send(producerRecord, new Callback() {
                @Override
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    //record is published successfully, if there is no exception
                    if(e == null){
                        log.info("Published into message: {}, topic: {}, partition: {}, offset: {}, timestamp: {}", msg, recordMetadata.topic(),
                                recordMetadata.partition(),
                                recordMetadata.offset(), recordMetadata.timestamp());
                    }else{
                        log.error("Exception is {}", e.getMessage());
                    }
                }
            });
        }
        this.producer.flush();
        this.producer.close();
    }

    public void publishRandomMessagesPerBatch(int counter, int batchSize){
        //Control + p --> getting the parameters
        //sticky partition, publishing same message into same partitioner
        for(int j = 0; j < batchSize; j++) {
            for(int i = 0; i < counter; i++){
                String msg = generateRandomString(10);
                log.info("Publishing the message into topic ");
                ProducerRecord<String,String> producerRecord = new ProducerRecord<>(topicName, msg);
                this.producer.send(producerRecord, new Callback() {
                    @Override
                    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                        //record is published successfully, if there is no exception
                        if(e == null){
                            log.info("Received topic: {}, partition: {}, offset: {}, timestamp: {}", recordMetadata.topic(),
                                    recordMetadata.partition(),
                                    recordMetadata.offset(), recordMetadata.timestamp());
                        }else{
                            log.error("Exception is {}", e.getMessage());
                        }
                    }
                });
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
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
        MyProducerWithCallback myProducer = new MyProducerWithCallback();
        //myProducer.publish();
        //myProducer.publishRandomMessages(9);
        myProducer.publishRandomMessagesPerBatch(9, 5);

    }
}
