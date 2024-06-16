package com.venkat.multiDatasource.user.service;

import com.venkat.multiDatasource.user.model.User;
import com.venkat.multiDatasource.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getById(Integer id){
        return userRepository.findById(id);
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public User update(User user){
        return userRepository.save(user);
    }

    public String deleteById(Integer id){
        userRepository.deleteById(id);
        return "User is deleted...";
    }
}
