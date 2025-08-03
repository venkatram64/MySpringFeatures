package com.venkat.sg;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Gatherer;

public final class MyPostGatherer  {

    MyPostGatherer() {}

    public static <K> Gatherer<MyPost, Map<K, List<MyPost>>, Map.Entry<K, List<MyPost>>> groupByWithLimit(
            Function<? super MyPost, ? extends K> keyExtractor,
            int limit,
            Comparator<? super MyPost> comparator) {

        return Gatherer.of(
                //initialize map
                HashMap<K, List<MyPost>>::new,
                //process each post into map
                (map, post, downstream) -> {
                    //extract the key from the post
                    K key = keyExtractor.apply(post);
                    //add the post to group by key
                    map.computeIfAbsent(key, k -> new ArrayList<>())
                            .add(post);
                    //continue processing the stream
                    return true;
                },
                //combiner for parallel streams, just use the first map in this simple case
                (map1, map2) -> map1,

                //when all posts have been processed, emit the results
                (map, downstream) -> {
                    //sort the posts and limit to the specified number
                    map.forEach((key, posts) -> {
                        List<MyPost> sortedPosts = posts.stream()
                                .sorted(comparator)
                                .limit(limit)
                                .toList();
                        //emit a Map.Entry with the key and sorted posts
                        downstream.push(Map.entry(key, sortedPosts));
                    });
                }
        );
    }

}
