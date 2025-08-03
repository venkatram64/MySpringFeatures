package com.venkat.http.client;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MyHttpClient {

    private static String url = "https://jsonplaceholder.typicode.com/posts";

    public static void process() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("Accept", "application/json")
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        //System.out.println(response.body());

        ObjectMapper mapper = new ObjectMapper();
        Post[] posts = mapper.readValue(response.body(), Post[].class);
        for (Post post : posts) {
            System.out.println(post);
        }

    }


    public static void main(String[] args) {
        try {
            process();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
