package com.venkat.multi.springMultiConfig.model;

import org.springframework.data.annotation.Id;

public record Employee(@Id Integer id, String name, String email, Double salary) {
}
