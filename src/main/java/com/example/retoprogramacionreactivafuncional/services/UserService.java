package com.example.retoprogramacionreactivafuncional.services;

import com.example.retoprogramacionreactivafuncional.model.User;
import com.example.retoprogramacionreactivafuncional.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public Flux<User> getAllUsers(){
        return repository.findAll();
    }

    public Mono<ResponseEntity<User>> getUserById(String id){
        return repository.findAllByIdUser(id)
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public Mono<ResponseEntity<User>> createUser(User user){
        return repository.insert(user)
                .map(u -> new ResponseEntity<>(u, HttpStatus.ACCEPTED))
                .defaultIfEmpty(new ResponseEntity<>(user, HttpStatus.NOT_FOUND));
    }

    public Mono<ResponseEntity<User>> updateUser(User user, String id){
        return repository.findById(id)
                .flatMap(user1 -> {
                    user.setIdUser(id);
                    return repository.save(user)
                            .map(user2 -> new ResponseEntity<>(user2, HttpStatus.ACCEPTED));
                }).defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public Mono<Void> deleteUser(String id){
        return repository.deleteById(id);
    }

}
