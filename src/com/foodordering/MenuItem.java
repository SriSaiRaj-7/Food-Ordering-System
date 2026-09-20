package com.foodordering;

// Abstraction: common blueprint for every menu item.
public abstract class MenuItem {
    private int itemId;
    private String name;
    private double price;

    protected MenuItem(int itemId, String name, double price) {
        setItemId(itemId);
        setName(name);
        setPrice(price);
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        if (itemId <= 0) {
            throw new IllegalArgumentException("Item ID must be positive.");
        }
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Item name cannot be empty.");
        }
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        this.price = price;
    }

    // Polymorphism: each subclass supplies its own category.
    public abstract String getCategory();

    public String getDescription() {
        return getName();
    }
}
