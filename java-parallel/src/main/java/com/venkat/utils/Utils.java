package com.venkat.utils;

import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static java.lang.Thread.sleep;


public class Utils {

    private static final Logger log = LoggerFactory.getLogger(Utils.class);
    public static StopWatch stopWatch = new StopWatch();

    public static void delay(long delayInMillSeconds){
        try{
            Thread.sleep(delayInMillSeconds);
        }catch (Exception e){
            log.info("Exception is :" + e.getMessage());
        }
    }

    public static void startTimer(){
        stopWatch.start();
    }

    public static void timeTaken(){
        stopWatch.stop();
        log.info("Total time taken " + stopWatch.getTime());
    }

    public static void reset(){
        stopWatch.reset();
    }

    public static int numberOfCores(){
        return Runtime.getRuntime().availableProcessors();
    }

    public static String transform(String s){
        delay(500);
        return s.toUpperCase();
    }

    public static void sleep(Duration duration){
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static long timer(Runnable runnable){
        var start = System.currentTimeMillis();
        runnable.run();
        var end = System.currentTimeMillis();
        //log.info("Time taken {}", (end - start));
        return (end - start);
    }
}
