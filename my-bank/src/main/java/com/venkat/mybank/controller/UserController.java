package com.venkat.mybank.controller;

import com.venkat.mybank.model.User;
import com.venkat.mybank.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Integer id){
        return ResponseEntity.ok(userService.getUserById(id).get());
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("/register")
    public ResponseEntity<User> create(@RequestBody User user){
        return ResponseEntity.ok(userService.save(user));
    }

    @PutMapping("/update")
    public ResponseEntity<User> update(@RequestBody User user){
        return ResponseEntity.ok(userService.update(user));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        userService.delete(id);
        return ResponseEntity.ok("User is deleted");
    }

}
