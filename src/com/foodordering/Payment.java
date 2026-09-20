package com.foodordering;

// Abstraction: every payment method follows the same payment contract.
public abstract class Payment {
    public abstract void processPayment(double amount);
}
