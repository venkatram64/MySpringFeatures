package com.venkat.routes.one;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CurrentTimerBean {

    public String getCurrentTime() {
        return "Current time is " + LocalDateTime.now();
    }

}
