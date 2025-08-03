package com.venkat.sg;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MyPostMain {

    private static List<MyPost> myPosts() {

        return List.of(
                new MyPost(1L, "Getting Started with Java", "Alice Smith",
                        "Java is a powerful programming language...", "Programming",
                        LocalDateTime.of(2023, 5, 10, 14, 30)),

                new MyPost(2L, "\"Travel Tips for USA", "Bob Johnson",
                        "Planning a trip to USA? Here are some tips...", "Travel",
                        LocalDateTime.of(2023, 6, 15, 9, 15)),

                new MyPost(3L, "Travel Tips for Europe", "Carol Williams",
                        "Planning a trip to Europe? Here are some tips...", "Travel",
                        LocalDateTime.of(2023, 7, 22, 11, 45)),

                new MyPost(4L, "Introduction to Machine Learning", "David Brown",
                        "Machine learning is transforming industries...", "Technology",
                        LocalDateTime.of(2023, 8, 5, 16, 20)),

                new MyPost(5L, "Introduction to LLM", "Eve Davis",
                        "LLM is revolutionizing the world...", "Technology",
                        LocalDateTime.of(2023, 9, 18, 13, 10)),

                new MyPost(6L, "Financial Planning for Beginners", "Frank Miller",
                        "Taking control of your finances starts with...", "Finance",
                        LocalDateTime.of(2023, 10, 3, 10, 30)),

                new MyPost(7L, "Financial Planning for Advanced Users", "Grace Wilson",
                        "Taking control of your finances starts with...", "Finance",
                        LocalDateTime.of(2023, 11, 12, 15, 45)),

                new MyPost(8L, "Yoga for Stress Relief", "Henry Taylor",
                        "Practicing yoga can significantly reduce...", "Health",
                        LocalDateTime.of(2023, 12, 8, 8, 0)),

                new MyPost(9L, "Health and Wellness Tips", "Ivy Anderson",
                        "Health and wellness tips for a healthy lifestyle...", "Health",
                        LocalDateTime.of(2024, 1, 20, 14, 15)),

                new MyPost(10L, "The Future of Health", "Jack Thomas",
                        "Health is a crucial aspect of our well-being...", "Health",
                        LocalDateTime.of(2024, 2, 14, 11, 30)),
                new MyPost(11L, "Getting Started with Advanced Java", "Mike Jones",
                        "Java is a powerful programming language, leaning towards advanced features...", "Programming",
                        LocalDateTime.of(2022, 5, 10, 14, 30)),
                new MyPost(12L, "Getting Started with Java Streams", "Venkat Veerareddy",
                        "Java is a powerful programming language, leaning towards streams...", "Programming",
                        LocalDateTime.of(2025, 5, 10, 14, 30))
        );
    }

    private static void streamGatherProcessByCategory(List<MyPost> myPosts, String category) {
        List<MyPost> list = myPosts.stream()
                .filter(post -> post.category().equals(category))
                .sorted(Comparator.comparing(MyPost::createdAt).reversed())
                .limit(3)
                .toList();
        list.forEach(System.out::println);
    }

    private static void streamGatherByCategory(List<MyPost> myPosts) {
        Map<String,List<MyPost>> list = myPosts.stream()
                        .gather(MyPostGatherer
                                .groupByWithLimit(
                                        MyPost::category, 3,
                                        Comparator.comparing(MyPost::createdAt).reversed()
                                )
                        )
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        list.forEach((k,v)-> {
            System.out.println("Category: " + k);
            v.forEach(System.out::println);
        });
    }
    //top three posts by category

    private static void streamProcessByCategoryBeforeJava24(List<MyPost> myPosts) {
        Map<String, List<MyPost>> postByCat = myPosts.stream()
                //group by category
                .collect(Collectors.groupingBy(
                        MyPost::category,
                        //collect posts into list
                        Collectors.collectingAndThen(
                                //collect posts into a list
                                Collectors.toList(),
                                //streaming, sorting and limit
                                categoryPosts -> categoryPosts.stream()
                                        .sorted(Comparator.comparing(MyPost::createdAt).reversed())
                                        .limit(3)
                                        .toList()
                        )));

        postByCat.forEach((k, v) -> {
            System.out.println("Category: " + k);
            if (v != null) {
                v.forEach(System.out::println);
            }
        });
    }

    //top three posts by category
    private static void streamProcessByCategoryWithMapBeforeJava24(List<MyPost> myPosts) {
        Map<String, List<MyPost>> postsByCat = myPosts.stream()
                //group by category
                .collect(Collectors.groupingBy(MyPost::category))
                //convert to stream of map
                .entrySet()
                .stream()
                // convert each entry to new map
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                       entry -> entry.getValue().stream()
                                .sorted(Comparator.comparing(MyPost::createdAt).reversed())
                                .limit(3)
                                .toList())
                );

        postsByCat.forEach((k, v) -> {
            System.out.println("Category: " + k);
            if (v != null) {
                v.forEach(System.out::println);
            }
        });
    }

    public static void main(String[] args) {
        List<MyPost> myPosts = myPosts();
        //streamGatherProcessByCategory(myPosts, "Programming");
        //streamProcessByCategoryBeforeJava24(myPosts);
        //streamProcessByCategoryWithMapBeforeJava24(myPosts);
        streamGatherByCategory(myPosts);
    }
}
