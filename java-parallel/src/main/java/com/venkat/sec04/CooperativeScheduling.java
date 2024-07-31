package com.venkat.sec04;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

public class CooperativeScheduling {

    private final static Logger log = LoggerFactory.getLogger(CooperativeScheduling.class);

    static {//below settings make the system single processor only
        System.setProperty("jdk.virtualThreadScheduler.parallelism", "1");
        System.setProperty("jdk.virtualThreadScheduler.maxPoolSize", "1");
    }
    public static void main(String[] args) throws InterruptedException {
        var builder = Thread.ofVirtual();
        CountDownLatch latch = new CountDownLatch(2);
        var t1 = builder.unstarted(() -> {
            processYield(1);
            latch.countDown();
        });
        var t2 = builder.unstarted(() -> {
            processYield(2);
            latch.countDown();
        });
        t1.start();
        t2.start();
        latch.await();
    }

    private static void processYield(int threadNumber){
        log.info("Thread-{} started", threadNumber);
        for(int i = 0; i < 10; i++){
            log.info("Thread-{} is printing {}, thread info {}", threadNumber, i, Thread.currentThread());
            Thread.yield();
        }
        log.info("Thread-{} ended", threadNumber);
    }

    private static void process(int threadNumber){
        log.info("Thread-{} started", threadNumber);
        for(int i = 0; i < 10; i++){
            log.info("Thread-{} is printing {}, thread info {}", threadNumber, i, Thread.currentThread());
        }
        log.info("Thread-{} ended", threadNumber);
    }
}
