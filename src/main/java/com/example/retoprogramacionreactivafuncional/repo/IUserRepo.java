package com.example.retoprogramacionreactivafuncional.repo;

import com.example.retoprogramacionreactivafuncional.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IUserRepo {
    Mono<User> register(User user);
    Mono<User> update(User user);
    Mono<Void> delete(Integer id);
    Flux<User> list();
    Mono<User> listById(Integer id);
}
