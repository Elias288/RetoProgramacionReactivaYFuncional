package com.example.retoprogramacionreactivafuncional.repo;

import com.example.retoprogramacionreactivafuncional.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveMongoRepository<User, String> {
    Mono<User> findAllByIdUser(String id);
}
