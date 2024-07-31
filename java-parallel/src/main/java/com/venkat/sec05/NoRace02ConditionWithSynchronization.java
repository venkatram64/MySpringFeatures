package com.venkat.sec05;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class NoRace02ConditionWithSynchronization {

    private final static Logger log = LoggerFactory.getLogger(NoRace02ConditionWithSynchronization.class);

    private static final List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        //process(Thread.ofPlatform());
        process(Thread.ofVirtual());
    }

    private static void process(Thread.Builder builder) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(50);
        for(int i = 0; i < 50; i++){
            builder.start(() -> {
                log.info("Task started {}", Thread.currentThread());
                for(int j = 0; j < 200; j++){
                    inMemory();
                }
                log.info("Task ended {}", Thread.currentThread());
                latch.countDown();
            });
        }
        latch.await();
        log.info("List size {}", list.size());
    }

    private static synchronized void  inMemory(){

        list.add(1);
    }
}
