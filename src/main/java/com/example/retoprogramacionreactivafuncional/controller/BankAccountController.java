package com.example.retoprogramacionreactivafuncional.controller;

import com.example.retoprogramacionreactivafuncional.model.BankAccount;
import com.example.retoprogramacionreactivafuncional.services.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/account")
public class BankAccountController {

    @Autowired
    public AccountsService service;

    @GetMapping
    public Flux<BankAccount> list(){
        return service.getAllAccounts();
    }

    @GetMapping("/{userId}")
    public Mono<ResponseEntity<BankAccount>> findByUserId(@PathVariable("userId") String userId){
        return service.getAccountByUserId(userId);
    }

    @PostMapping
    public Mono<ResponseEntity<BankAccount>> register(@RequestBody BankAccount bankAccount){
        return service.createBankAccount(bankAccount);
    }

    @PutMapping("/{accountId}")
    public Mono<ResponseEntity<BankAccount>> update(@RequestBody BankAccount bankAccount, @PathVariable String accountId){
        return service.updateBankAccount(bankAccount, accountId);
    }

    @DeleteMapping ("/{id}")
    public Mono<Void> delete(@PathVariable("id") String id){
        return service.delete(id);
    }

}
