package com.foodordering;

// Encapsulation: customer data is private and accessed through methods.
public class Customer {
    private int customerId;
    private String name;
    private String phoneNumber;

    public Customer(int customerId, String name, String phoneNumber) {
        setCustomerId(customerId);
        setName(name);
        setPhoneNumber(phoneNumber);
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        if (customerId <= 0) {
            throw new IllegalArgumentException("Customer ID must be positive.");
        }
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be empty.");
        }
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be empty.");
        }
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer #" + customerId + " - " + name + " (" + phoneNumber + ")";
    }
}
