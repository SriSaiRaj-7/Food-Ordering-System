package com.foodordering;

// Inheritance: Beverage shares MenuItem's common contract.
public class Beverage extends MenuItem {
    public Beverage(int itemId, String name, double price) {
        super(itemId, name, price);
    }

    // Method overriding demonstrates polymorphic category behavior.
    @Override
    public String getCategory() {
        return "Beverage";
    }

    @Override
    public String getDescription() {
        return "Refreshing " + getName();
    }
}
