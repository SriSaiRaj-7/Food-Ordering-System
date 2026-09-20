package com.foodordering;

// Inheritance and polymorphism: UPI supplies its own payment behavior.
public class UpiPayment extends Payment {
    @Override
    public void processPayment(double amount) {
        System.out.printf("UPI payment of %.2f completed successfully.%n", amount);
    }
}
