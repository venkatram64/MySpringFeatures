package com.venkat.sec06;

import com.venkat.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadFactory;

public class ThreadFactory02UsefulMethods {
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

    private static final Logger log = LoggerFactory.getLogger(ThreadFactory02UsefulMethods.class);


    public static void main(String[] args) throws InterruptedException {
        isVirtual();
        join();
        interrupt();
    }

    private static void isVirtual(){
        var t1 = Thread.ofVirtual()
                .start(() -> Utils.sleep(Duration.ofSeconds(2)));
        var t2 = Thread.ofPlatform()
                .start(() -> Utils.sleep(Duration.ofSeconds(2)));
        log.info("Is t1 virtual {}", t1.isVirtual());
        log.info("Is t2 virtual {}", t2.isVirtual());
        log.info("Is current thread virtual {}", Thread.currentThread().isVirtual());
    }

    private static void join(){
        var t1 = Thread.ofVirtual()
                .start(() -> {
                    Utils.sleep(Duration.ofSeconds(2));
                    log.info("Called product service");
                });
        var t2 = Thread.ofVirtual()
                .start(() -> {
                    Utils.sleep(Duration.ofSeconds(2));
                    log.info("Called pricing service");
                });
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void interrupt(){
        var t1 = Thread.ofVirtual()
                .start(() -> Utils.sleep(Duration.ofSeconds(2)));
        log.info("Is t1 interrupted {}", t1.isInterrupted());
        t1.interrupt();
        log.info("Is t1 interrupted {}", t1.isInterrupted());
    }
}

