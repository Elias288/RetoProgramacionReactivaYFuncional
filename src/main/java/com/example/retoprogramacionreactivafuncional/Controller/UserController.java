package com.example.retoprogramacionreactivafuncional.Controller;

import com.example.retoprogramacionreactivafuncional.model.User;
import com.example.retoprogramacionreactivafuncional.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/usuario")
public class UserController {
    private final UserRepository repo;
    @Autowired
    public UserController(UserRepository repo){
        this.repo = repo;
    }

    @GetMapping
    public Flux<User> list(){
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<User>> listById(@PathVariable("id") String id){
        return repo.findAllByIdUser(id)
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public Mono<ResponseEntity<User>> register(@RequestBody User user){
        return repo.insert(user)
                .map(u -> new ResponseEntity<>(u, HttpStatus.ACCEPTED))
                .defaultIfEmpty(new ResponseEntity<>(user, HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<User>> update(@RequestBody User user, @PathVariable String id){
        return repo.findById(id)
                .flatMap(user1 -> {
                    user.setIdUser(id);
                    return repo.save(user)
                            .map(user2 -> new ResponseEntity<>(user2, HttpStatus.ACCEPTED));
                }).defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping ("/{id}")
    public Mono<Void> delete(@PathVariable("id") String id){
        return repo.deleteById(id);
    }

}
