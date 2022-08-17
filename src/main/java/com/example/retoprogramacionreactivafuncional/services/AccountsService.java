package com.example.retoprogramacionreactivafuncional.services;

import com.example.retoprogramacionreactivafuncional.model.BankAccount;
import com.example.retoprogramacionreactivafuncional.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountsService {

    @Autowired
    private AccountRepository repository;

    public Flux<BankAccount> getAllAccounts(){
        return repository.findAll();
    }

    public Mono<ResponseEntity<BankAccount>> getAccountByUserId(String userId){
        return repository.findAllByUserId(userId)
                .map(bankAccount -> new ResponseEntity<>(bankAccount, HttpStatus.ACCEPTED))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public Mono<ResponseEntity<BankAccount>> createBankAccount(BankAccount bankAccount){
        return repository.insert(bankAccount)
                .map(bankAccount1 -> new ResponseEntity<>(bankAccount1, HttpStatus.ACCEPTED))
                .defaultIfEmpty(new ResponseEntity<>(bankAccount, HttpStatus.NOT_FOUND));
    }

    public Mono<ResponseEntity<BankAccount>> updateBankAccount(BankAccount bankAccount, String accountId){
        return repository.findById(accountId)
                .flatMap(bankAccount1 -> {
                    bankAccount.setIdAccount(accountId);
                    return repository.save(bankAccount)
                            .map(bankAccount2 -> new ResponseEntity<>(bankAccount2, HttpStatus.ACCEPTED));
                }).defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public Mono<Void> delete(String id){return repository.deleteById(id);}
}
