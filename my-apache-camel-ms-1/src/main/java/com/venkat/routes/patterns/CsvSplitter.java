package com.venkat.routes.patterns;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CsvSplitter {

    public List<String> split(String body) {
        return List.of(body.split(","));
    }
}
