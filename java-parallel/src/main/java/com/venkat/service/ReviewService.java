package com.venkat.service;

import com.venkat.model.Review;
import org.springframework.stereotype.Service;

import static com.venkat.utils.Utils.delay;


@Service
public class ReviewService {

    public Review fetchReview(String productId){
        delay(1000);
        return new Review(200, 4.5);
    }
}
