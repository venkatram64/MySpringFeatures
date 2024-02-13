package com.venkat.mybank.repository;

import com.venkat.mybank.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    //derived method query language
    User findByEmail(String email);
}
