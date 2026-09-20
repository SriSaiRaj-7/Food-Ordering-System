package com.foodordering;

// Inheritance and polymorphism: card supplies its own payment behavior.
public class CardPayment extends Payment {
    @Override
    public void processPayment(double amount) {
        System.out.printf("Card payment of %.2f approved successfully.%n", amount);
    }
}
