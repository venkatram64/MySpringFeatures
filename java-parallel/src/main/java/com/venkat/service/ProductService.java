package com.venkat.service;

import com.venkat.model.Product;
import com.venkat.model.ProductInfo;
import com.venkat.model.Review;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.venkat.utils.Utils.stopWatch;

@Service
@Slf4j
public class ProductService {

    private ProductInfoService infoService;
    private ReviewService reviewService;

    public ProductService(ProductInfoService infoService, ReviewService reviewService){
        this.infoService = infoService;
        this.reviewService = reviewService;
    }

    public Product productDetails(String productId){

        stopWatch.start();

        ProductInfo productInfo = infoService.retrieveProductInfo(productId);
        Review review = reviewService.fetchReview(productId);

        stopWatch.stop();
        log.info("Total Time Taken : "+ stopWatch.getTime());
        return new Product(productId, productInfo, review);
    }
}
