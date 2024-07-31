package com.venkat.sec05;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NoRace05ConditionWithReentrantLock {

    private final static Logger log = LoggerFactory.getLogger(NoRace05ConditionWithReentrantLock.class);

    private static final List<Integer> list = new ArrayList<>();
    private static final Lock lock = new ReentrantLock();

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

    private static  void  inMemory(){
        try{
            lock.lock();
            list.add(1);
        }catch (Exception e){
            log.info("Exception occurred ");
        }finally {
            lock.unlock();
        }

    }
}
