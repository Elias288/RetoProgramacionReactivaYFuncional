package com.example.retoprogramacionreactivafuncional.repo;

import com.example.retoprogramacionreactivafuncional.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepoImpl implements IUserRepo {

    private static final Logger log = LoggerFactory.getLogger(UserRepoImpl.class);


    @Override
    public Mono<User> register(User user) {
        log.info(user.toString());
        return Mono.just(user);
    }

    @Override
    public Mono<User> update(User user) {
        log.info(user.toString());
        return Mono.just(user);
    }

    @Override
    public Mono<Void> delete(Integer id) {
        return Mono.empty();
    }

    @Override
    public Flux<User> list() {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Eddi", 32));
        users.add(new User(2, "Luciano", 29));
        users.add(new User(3, "Yissel", 22));
        users.add(new User(4, "Giannia", 21));

        return Flux.fromIterable(users);
    }

    @Override
    public Mono<User> listById(Integer id) {
        return Mono.just(new User(id, "Eddi", 32));
    }
}
