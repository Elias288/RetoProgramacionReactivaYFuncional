package com.example.retoprogramacionreactivafuncional.repo;

import com.example.retoprogramacionreactivafuncional.model.BankAccount;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface AccountRepository extends ReactiveMongoRepository<BankAccount, String > {
    Mono<BankAccount> findAllByUserId(String id);
}
