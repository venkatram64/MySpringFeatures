package com.venkat.sec02;

import java.util.concurrent.CountDownLatch;

public class StackTraceDemo {

    public static void main(String[] args) {
        //demo(Thread.ofPlatform());
        demo(Thread.ofVirtual().name("Virtual-",1));
    }

    private static void demo(Thread.Builder builder){
        CountDownLatch latch = new CountDownLatch(24);
        for(int i = 0; i <=24; i++){
            int j = i;
            builder.start(() -> {
                Task.execute(j);
                latch.countDown();
            });
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
