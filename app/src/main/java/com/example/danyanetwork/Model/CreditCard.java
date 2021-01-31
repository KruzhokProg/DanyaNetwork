package com.example.danyanetwork.Model;

public class CreditCard {
    private int id;
    private String cardNumber;
    private int balance;

    public CreditCard(int id, String cardNumber, int balance) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.balance = balance;
    }

    public CreditCard()
    {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
