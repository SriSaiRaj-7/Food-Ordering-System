package com.foodordering;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Encapsulation: the restaurant manages its private menu collection.
public class Restaurant {
    private final List<MenuItem> availableItems = new ArrayList<>();

    public Restaurant() {
        loadSampleMenu();
    }

    public void addMenuItem(MenuItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Menu item cannot be null.");
        }
        availableItems.add(item);
    }

    public void displayMenu() {
        System.out.println("\n==================== MENU ====================");
        System.out.printf("%-4s %-24s %-18s %10s%n", "ID", "ITEM", "CATEGORY", "PRICE");
        System.out.println("------------------------------------------------");
        for (MenuItem item : availableItems) {
            System.out.printf("%-4d %-24s %-18s %10.2f%n", item.getItemId(), item.getName(),
                    item.getCategory(), item.getPrice());
        }
        System.out.println("================================================");
    }

    public MenuItem findItemById(int itemId) {
        for (MenuItem item : availableItems) {
            if (item.getItemId() == itemId) {
                return item;
            }
        }
        return null;
    }

    public List<MenuItem> getAvailableItems() {
        return Collections.unmodifiableList(availableItems);
    }

    private void loadSampleMenu() {
        addMenuItem(new VegItem(1, "Paneer Tikka", 180.00));
        addMenuItem(new VegItem(2, "Veg Biryani", 220.00));
        addMenuItem(new VegItem(3, "Margherita Pizza", 250.00));
        addMenuItem(new VegItem(4, "Masala Dosa", 140.00));
        addMenuItem(new NonVegItem(5, "Chicken Biryani", 280.00));
        addMenuItem(new NonVegItem(6, "Chicken Burger", 210.00));
        addMenuItem(new NonVegItem(7, "Fish and Chips", 300.00));
        addMenuItem(new Beverage(8, "Fresh Lime Soda", 70.00));
        addMenuItem(new Beverage(9, "Mango Lassi", 90.00));
        addMenuItem(new Beverage(10, "Cold Coffee", 120.00));
    }
}
