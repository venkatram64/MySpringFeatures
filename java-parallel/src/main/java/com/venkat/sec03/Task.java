package com.venkat.sec03;

import com.venkat.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Task {
    private static final Logger log = LoggerFactory.getLogger(com.venkat.sec01.Task.class);

    public static void cpuIntensive(int i){
        log.info("Starting CPU task, Thread info {} ", Thread.currentThread());
        var timeTaken = Utils.timer(() -> findFib(i));
        log.info("Time taken {} ms", timeTaken);
    }

    public static void cpuIntensiveWithNoLogs(int i){
        var timeTaken = Utils.timer(() -> findFib(i));
    }
    public static long findFib(long input){
        if(input < 2){
            return input;
        }
        return findFib(input - 1) + findFib(input - 2);
    }
}
