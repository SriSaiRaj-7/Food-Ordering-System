package com.foodordering;

// Inheritance and polymorphism: cash supplies its own payment behavior.
public class CashPayment extends Payment {
    @Override
    public void processPayment(double amount) {
        System.out.printf("Cash payment selected. Collect %.2f at the counter.%n", amount);
    }
}
