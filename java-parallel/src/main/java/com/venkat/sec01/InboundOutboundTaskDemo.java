package com.venkat.sec01;

import java.time.Duration;
import java.util.concurrent.CountDownLatch;

public class InboundOutboundTaskDemo {

    public static final int MAX_PLATFORM = 10;
    public static final int MAX_VIRTUAL = 24;//1_000_000;

    public static void main(String[] args) throws InterruptedException {
        //platformThreadDemo3();
        virtualThreadDemo();
    }

    private static void platformThreadDemo(){
        for(int i = 0; i < MAX_PLATFORM; i++){
            int j = i;
            Thread thread = new Thread(() -> Task.ioIntensiveTask(j));
            thread.start();
        }
    }

    private static void platformThreadDemo2(){
        Thread.Builder.OfPlatform platformThread = Thread
                                .ofPlatform()
                                .name("PlatformThread-", 0);
        for(int i = 0; i < MAX_PLATFORM; i++){
            int j = i;
            Thread thread = platformThread
                            .unstarted(() -> Task.ioIntensiveTask(j));
            thread.start();
        }
    }

    private static void platformThreadDemo3() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(MAX_PLATFORM);
        Thread.Builder.OfPlatform platformThread = Thread
                .ofPlatform()
                .daemon()
                .name("PlatformThread-", 0);
        for(int i = 0; i < MAX_PLATFORM; i++){
            int j = i;
            Thread thread = platformThread
                    .unstarted(() -> {
                        Task.ioIntensiveTask(j);
                        latch.countDown();
                    });
            thread.start();

        }

        latch.await();//so main thread waits, to complete the all spawned threads task
    }

    //virtual threads are by default daemon threads
    //virtual threads are not have, any name
    private static void virtualThreadDemo() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(MAX_VIRTUAL);
        Thread.Builder.OfVirtual virtualThread = Thread
                .ofVirtual()
                .name("VirtualThread-", 1);
        for(int i = 0; i < MAX_VIRTUAL; i++){
            int j = i;
            Thread thread = virtualThread
                    .unstarted(() -> {
                        Task.ioIntensiveTask(j);
                        latch.countDown();
                    });
            thread.start();
        }
        latch.await();
    }
}
