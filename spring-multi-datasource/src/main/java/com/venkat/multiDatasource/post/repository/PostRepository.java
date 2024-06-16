package com.venkat.multiDatasource.post.repository;

import com.venkat.multiDatasource.post.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
}
