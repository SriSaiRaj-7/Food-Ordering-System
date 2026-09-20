package com.foodordering;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Encapsulation: the cart controls access to its private item collection.
public class Cart {
    private final List<MenuItem> items = new ArrayList<>();

    public void addItem(MenuItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot add a null item.");
        }
        items.add(item);
    }

    public boolean removeItem(int itemId) {
        return items.removeIf(item -> item.getItemId() == itemId);
    }

    public double getTotal() {
        return items.stream().mapToDouble(MenuItem::getPrice).sum();
    }

    // Polymorphism: MenuItem references call each subclass's overridden methods.
    public void viewCart() {
        if (items.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }
        System.out.println("\n---------------- CART ----------------");
        for (MenuItem item : items) {
            System.out.printf("%-4d %-24s %10.2f%n", item.getItemId(), item.getDescription(), item.getPrice());
        }
        System.out.printf("---------------------------------------%nTotal: %.2f%n", getTotal());
    }

    public void clearCart() {
        items.clear();
    }

    public List<MenuItem> getItems() {
        return Collections.unmodifiableList(items);
    }
}
