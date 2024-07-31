package com.venkat.sec03;

import com.venkat.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

public class CPUTask {
    private static final Logger log = LoggerFactory.getLogger(Task.class);
    private static final int TASK_COUNT = 3 * Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {

        /*log.info("Starting CPU task. Thread info {}", Thread.currentThread());
        long timeTaken = Utils.timer(() -> Task.findFib(46));
        log.info("Time taken {} ms", timeTaken);*/

        //process(Thread.ofPlatform());
        //process(Thread.ofVirtual().name("Virtual-", 1));
        processWithTotalTime();
    }

    private static void processWithTotalTime(){
        for(int i = 0; i < 3; i++){
            var totalTimeTaken = Utils.timer(() -> processTotalTime(Thread.ofVirtual().name("Virtual-", 1)));
            log.info("Total time taken with virtual {} ms", totalTimeTaken);
            totalTimeTaken = Utils.timer(() -> processTotalTime(Thread.ofPlatform()));
            log.info("Total time taken with platform {} ms", totalTimeTaken);
        }
    }

    private static void processTotalTime(Thread.Builder builder){
        CountDownLatch latch = new CountDownLatch(TASK_COUNT);
        for(int i = 1; i <= TASK_COUNT; i++){
            builder.start(() -> {
                Task.cpuIntensiveWithNoLogs(45);
                latch.countDown();
            });
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void process(Thread.Builder builder){
        CountDownLatch latch = new CountDownLatch(TASK_COUNT);
        for(int i = 1; i <= TASK_COUNT; i++){
            builder.start(() -> {
                Task.cpuIntensive(45);
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
