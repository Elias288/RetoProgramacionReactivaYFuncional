package com.example.retoprogramacionreactivafuncional.Controller;

import com.example.retoprogramacionreactivafuncional.model.User;
import com.example.retoprogramacionreactivafuncional.repo.IUserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/usuario")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserRepo repo;

    @GetMapping
    public Flux<User> list(){
        return repo.list();
    }

    @GetMapping("/{id}")
    public Mono<User> listById(@PathVariable("id") Integer id){
        return repo.listById(id);
    }

    @PostMapping
    public Mono<User> register(@RequestBody User user){
        return repo.register(user);
    }

    @PutMapping
    public Mono<User> update(@RequestBody User user){
        return repo.update(user);
    }

    @DeleteMapping ("/{id}")
    public Mono<Void> delete(@PathVariable("id") Integer id){
        return repo.delete(id);
    }

}
