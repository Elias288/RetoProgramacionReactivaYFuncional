package com.example.retoprogramacionreactivafuncional.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document(collection = "bankAccount")
public class BankAccount {
    @Id
    private String idAccount;
    private String userId;
    private double balance = 0;
    private double entry = 0;
    private double withdrawal = 0;
    private List<Movement> movements = new ArrayList<>();

    public BankAccount(){}

    public BankAccount(String userId) {
        this.userId = userId;
    }

    public String getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUser(String userId) {
        this.userId = userId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getEntry() {
        return entry;
    }

    public void setEntry(double entry) {
        this.entry = entry;
    }

    public double getWithdrawal() {
        return withdrawal;
    }

    public void setWithdrawal(double withdrawal) {
        this.withdrawal = withdrawal;
    }

    public List<Movement> getMovements() {
        return movements;
    }

    public void setMovements(List<Movement> movements) {
        this.movements = movements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return Objects.equals(idAccount, that.idAccount) && Objects.equals(userId, that.userId) && Objects.equals(balance, that.balance) && Objects.equals(entry, that.entry) && Objects.equals(withdrawal, that.withdrawal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAccount, userId, balance, entry, withdrawal);
    }
}
