package com.foodordering;

// Inheritance: NonVegItem is another specialized MenuItem.
public class NonVegItem extends MenuItem {
    public NonVegItem(int itemId, String name, double price) {
        super(itemId, name, price);
    }

    // Method overriding gives this item its own category.
    @Override
    public String getCategory() {
        return "Non-Vegetarian";
    }

    @Override
    public String getDescription() {
        return "Chef's non-vegetarian " + getName();
    }
}
