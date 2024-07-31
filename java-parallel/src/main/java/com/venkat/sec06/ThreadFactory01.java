package com.venkat.sec06;

import com.venkat.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadFactory01 {
    /**
     * Thread.Builder - It is not thread safe
     * for the following Thread.Builder is ok
     * main - Thread.Builder
     *          t1,t2, t3
     * main- create Thread.Builder factory
     * t1
     *  t11, t12, t13
     * t2
     *  t21, t22, t23
     * t3
     *  t31, t32, t33
     */

    private static final Logger log = LoggerFactory.getLogger(ThreadFactory01.class);


    public static void main(String[] args) throws InterruptedException {
        process(Thread.ofVirtual().name("Virtual-",1).factory());
    }

    private static void process(ThreadFactory factory) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(6);
        for(int i = 0; i < 3; i++){
            var t = factory.newThread(() -> {
                log.info("Task started {}", Thread.currentThread());
                var ct = factory.newThread(() -> {
                    log.info("Child task started {}", Thread.currentThread());
                    Utils.sleep(Duration.ofSeconds(2));
                    log.info("Child task started {}", Thread.currentThread());
                    latch.countDown();
                });
                ct.start();
                log.info("Task ended {}", Thread.currentThread());
                latch.countDown();
            });
            t.start();
        }
        latch.await();
        log.info("process ended");
    }


}

