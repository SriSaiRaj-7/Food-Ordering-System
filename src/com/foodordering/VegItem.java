package com.foodordering;

// Inheritance: VegItem reuses the common MenuItem state and behavior.
public class VegItem extends MenuItem {
    public VegItem(int itemId, String name, double price) {
        super(itemId, name, price);
    }

    // Method overriding demonstrates runtime polymorphism.
    @Override
    public String getCategory() {
        return "Vegetarian";
    }

    @Override
    public String getDescription() {
        return "Fresh vegetarian " + getName();
    }
}
