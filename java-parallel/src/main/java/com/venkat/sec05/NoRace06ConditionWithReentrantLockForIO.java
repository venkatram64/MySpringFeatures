package com.venkat.sec05;

import com.venkat.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NoRace06ConditionWithReentrantLockForIO {

    private final static Logger log = LoggerFactory.getLogger(NoRace06ConditionWithReentrantLockForIO.class);

    private static final List<Integer> list = new ArrayList<>();
    private static final Lock lock = new ReentrantLock();
    static {
        System.setProperty("jdk.tracePinnedThreads", "full");
    }
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> log.info("*** testing msg ***");
        //process(Thread.ofPlatform());
        //Thread.ofPlatform().start(runnable);
        process(Thread.ofVirtual());
        Thread.ofVirtual().start(runnable);
        /**
         * synchronized + virtual Thread --> Pinned
         * I/O tasks -> Virtual Thread can not be unmounted, would affect scaling
         */

    }

    private static void process(Thread.Builder builder) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(50);
        for(int i = 0; i < 50; i++){
            builder.start(() -> {
                log.info("Task started {}", Thread.currentThread());
                ioTask();
                log.info("Task ended {}", Thread.currentThread());
                latch.countDown();
            });
        }
        latch.await();
    }

    private static  void  ioTask(){
        try {
            lock.lock();
            list.add(1);
            Utils.sleep(Duration.ofSeconds(10));
        }catch (Exception e){
            log.info("Exception occurred");
        }finally {
            lock.unlock();
        }
    }
}
