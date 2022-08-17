package com.example.retoprogramacionreactivafuncional.controller;

import com.example.retoprogramacionreactivafuncional.model.User;
import com.example.retoprogramacionreactivafuncional.repo.UserRepository;
import com.example.retoprogramacionreactivafuncional.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/usuario")
public class UserController {
    @Autowired
    public UserService userService;

    @GetMapping
    public Flux<User> list(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<User>> listById(@PathVariable("id") String id){
        return userService.getUserById(id);
    }

    @PostMapping
    public Mono<ResponseEntity<User>> register(@RequestBody User user){
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<User>> update(@RequestBody User user, @PathVariable String id){
        return userService.updateUser(user, id);
    }

    @DeleteMapping ("/{id}")
    public Mono<Void> delete(@PathVariable("id") String id){
        return userService.deleteUser(id);
    }

}
