package com.venkat.sg;

import java.time.LocalDateTime;

public record MyPost(long id, String title, String author, String body, String category, LocalDateTime createdAt) {
}
