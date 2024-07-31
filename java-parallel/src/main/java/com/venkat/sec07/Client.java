package com.venkat.sec07;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;

public class Client {
    private static final Logger log = LoggerFactory.getLogger(Client.class);

    private static final String PRODUCT = "http://localhost:8080/api/product/%d";
    private static final String PRODUCT_RATING = "http://localhost:8080/api/rating/%d";


    public static String getProduct(int id){
        return callExternalServie(PRODUCT.formatted(id));
    }

    public static String getRating(String prod){
        return callExternalServie(PRODUCT.formatted(prod));
    }

    private static String callExternalServie(String url){
        log.info("Calling {}", url);
        try(var stream = URI.create(url).toURL().openStream()){
            return new String(stream.readAllBytes());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
