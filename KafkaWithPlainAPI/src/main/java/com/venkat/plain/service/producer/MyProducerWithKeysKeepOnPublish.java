package com.venkat.plain.service.producer;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.SecureRandom;
import java.util.Properties;

public class MyProducerWithKeysKeepOnPublish {

    private static final Logger log = LoggerFactory.getLogger(MyProducerWithKeysKeepOnPublish.class.getClass().getSimpleName());

    //to generate random messages
    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();
    //end of above code

    private KafkaProducer<String, String> producer;
    private String topicName = "my-test-topic";

    public MyProducerWithKeysKeepOnPublish(){
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

    public void publishRandomMessages(int counter){
        //Control + p --> getting the parameters
        //sticky partition, publishing same message into same partitioner
        for(int i = 0; i < counter; i++){
            String value = generateRandomString(10);
            log.info("Publishing the message into topic ");
            //if we use same key, it goes to same partition,
            //if we want to send particular data into same partition, so use the same key
            String key = "id_" + i;
            ProducerRecord<String,String> producerRecord = new ProducerRecord<>(topicName, key, value);
            this.producer.send(producerRecord, new Callback() {
                @Override
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    //record is published successfully, if there is no exception
                    if(e == null){
                        log.info("Published into message: {}, topic: {}, key: {}, partition: {}, offset: {}, timestamp: {}", value, recordMetadata.topic(),
                                key, recordMetadata.partition(),
                                recordMetadata.offset(), recordMetadata.timestamp());
                    }else{
                        log.error("Exception is {}", e.getMessage());
                    }
                }
            });
        }
        this.producer.flush();
        //this.producer.close();
    }


    public static String generateRandomString(int length){
        StringBuilder sb = new StringBuilder( length );
        for( int i = 0; i < length; i++ ) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        MyProducerWithKeysKeepOnPublish myProducer = new MyProducerWithKeysKeepOnPublish();
        while(true) {
            myProducer.publishRandomMessages(9);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
