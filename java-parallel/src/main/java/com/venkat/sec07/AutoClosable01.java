package com.venkat.sec07;

import com.venkat.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.concurrent.Executors;

public class AutoClosable01 {
    private static final Logger log = LoggerFactory.getLogger(AutoClosable01.class);

    public static void main(String[] args) {
        /*var executorService = Executors.newSingleThreadExecutor();
        executorService.submit(AutoClosable01::task);
        log.info("Submitted.");
        executorService.shutdown();*/
        try(var executorService = Executors.newSingleThreadExecutor()){
            executorService.submit(AutoClosable01::task);
            log.info("Submitted.");
        }
    }

    private static void task(){
        Utils.sleep(Duration.ofSeconds(1));
        log.info("task executed");
    }
}
