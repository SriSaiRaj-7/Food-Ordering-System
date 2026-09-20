package com.foodordering;

// Encapsulation: an order owns its customer, cart, payment, and status.
public class Order {
    private static int nextOrderId = 1001;
    private final int orderId;
    private Customer customer;
    private Cart cart;
    private String status;
    private Payment paymentMethod;

    public Order(Customer customer, Cart cart, Payment paymentMethod) {
        this.orderId = nextOrderId++;
        setCustomer(customer);
        setCart(cart);
        setPaymentMethod(paymentMethod);
        this.status = "PLACED";
    }

    public int getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer is required.");
        }
        this.customer = customer;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        if (cart == null) {
            throw new IllegalArgumentException("Cart is required.");
        }
        this.cart = cart;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        updateStatus(status);
    }

    public Payment getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Payment paymentMethod) {
        if (paymentMethod == null) {
            throw new IllegalArgumentException("Payment method is required.");
        }
        this.paymentMethod = paymentMethod;
    }

    public void placeOrder() {
        paymentMethod.processPayment(cart.getTotal());
        status = "PLACED";
        System.out.println("Order #" + orderId + " placed successfully.");
    }

    public void updateStatus(String newStatus) {
        if (!newStatus.equals("PLACED") && !newStatus.equals("PREPARING") && !newStatus.equals("DELIVERED")) {
            throw new IllegalArgumentException("Status must be PLACED, PREPARING, or DELIVERED.");
        }
        this.status = newStatus;
    }

    public void printOrderSummary() {
        System.out.println("\n================ ORDER SUMMARY ================");
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customer);
        cart.viewCart();
        System.out.println("Payment: " + paymentMethod.getClass().getSimpleName());
        System.out.println("Status: " + status);
        System.out.println("================================================");
    }
}
