package com.patterns.behavioral.strategy;

import java.util.ArrayList;
import java.util.List;

// Context
public class ShoppingCart {
    private List<Item> items;
    private PaymentStrategy paymentStrategy; // Holds a reference to a strategy

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        this.items.add(item);
        System.out.println(item.getName() + " added to cart. Price: $" + String.format("%.2f", item.getPrice()));
    }

    public void removeItem(Item item) {
        this.items.remove(item);
        System.out.println(item.getName() + " removed from cart.");
    }

    public double calculateTotal() {
        double sum = 0;
        for (Item item : items) {
            sum += item.getPrice();
        }
        return sum;
    }

    // Client can set the strategy at runtime
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
        System.out.println("Payment strategy set to: " + paymentStrategy.getPaymentMethodName());
    }

    public boolean checkout() {
        if (paymentStrategy == null) {
            System.err.println("Payment strategy not set. Cannot checkout.");
            return false;
        }
        double totalAmount = calculateTotal();
        System.out.println("Total amount to pay: $" + String.format("%.2f", totalAmount));
        if (totalAmount == 0) {
            System.out.println("Cart is empty. Nothing to checkout.");
            return true; // Or false, depending on desired behavior
        }
        return paymentStrategy.pay(totalAmount);
    }
}

// Helper class for items in the cart
class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
