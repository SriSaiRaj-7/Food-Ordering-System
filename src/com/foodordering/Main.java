package com.foodordering;

import java.util.Scanner;

// Main demonstrates object collaboration in a complete console application.
public class Main {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("===============================================");
        System.out.println("        WELCOME TO FOOD ORDERING SYSTEM        ");
        System.out.println("===============================================");

        while (running) {
            restaurant.displayMenu();
            System.out.println("1. Create order");
            System.out.println("2. Exit");
            int choice = readInt(scanner, "Choose an option: ");

            if (choice == 1) {
                createOrder(scanner, restaurant);
            } else if (choice == 2) {
                running = false;
                System.out.println("Thank you for visiting. Goodbye!");
            } else {
                System.out.println("Please choose 1 or 2.");
            }
        }
        scanner.close();
    }

    private static void createOrder(Scanner scanner, Restaurant restaurant) {
        Cart cart = new Cart();
        System.out.println("\nEnter item IDs to add. Enter 0 when finished.");

        while (true) {
            int itemId = readInt(scanner, "Item ID: ");
            if (itemId == 0) {
                break;
            }
            MenuItem item = restaurant.findItemById(itemId);
            if (item == null) {
                System.out.println("Invalid item ID. Please select an ID from the menu.");
            } else {
                cart.addItem(item);
                System.out.println(item.getName() + " added to your cart.");
            }
        }

        if (cart.getItems().isEmpty()) {
            System.out.println("No items selected. Returning to the main menu.");
            return;
        }

        cart.viewCart();
        String name = readText(scanner, "Customer name: ");
        String phone = readText(scanner, "Phone number: ");
        Customer customer = new Customer(1, name, phone);

        Payment payment = choosePayment(scanner);
        if (payment == null) {
            System.out.println("Invalid payment choice. Order cancelled.");
            return;
        }

        Order order = new Order(customer, cart, payment);
        order.placeOrder();
        order.printOrderSummary();
    }

    private static Payment choosePayment(Scanner scanner) {
        System.out.println("\nPayment methods:");
        System.out.println("1. Cash");
        System.out.println("2. Card");
        System.out.println("3. UPI");
        int choice = readInt(scanner, "Choose payment method: ");
        switch (choice) {
            case 1:
                return new CashPayment();
            case 2:
                return new CardPayment();
            case 3:
                return new UpiPayment();
            default:
                return null;
        }
    }

    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException exception) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static String readText(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("This value cannot be empty.");
        }
    }
}
