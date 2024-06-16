package com.venkat.multiDatasource.user.controller;

import com.venkat.multiDatasource.user.model.User;
import com.venkat.multiDatasource.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id){
        Optional<User> user = userService.getById(id);
        User userObj = user.get();
        return ResponseEntity.ok(userObj);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        return ResponseEntity.ok(userService.save(user));
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user){
        return ResponseEntity.ok(userService.update(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Integer id){
        return ResponseEntity.ok(userService.deleteById(id));
    }
}
