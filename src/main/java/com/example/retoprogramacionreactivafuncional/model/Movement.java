package com.example.retoprogramacionreactivafuncional.model;

import java.util.Date;

public class Movement {
    private String date;
    private double amount;

    public Movement(String date, double amount) {
        this.date = date;
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
