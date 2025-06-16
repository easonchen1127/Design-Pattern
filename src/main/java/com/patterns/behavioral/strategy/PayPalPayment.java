package com.patterns.behavioral.strategy;

// ConcreteStrategy B
public class PayPalPayment implements PaymentStrategy {
    private String email;
    private String password; // In a real app, this would be handled more securely (e.g., token)

    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password; // Storing password directly is bad practice; for demo only
        System.out.println("PayPalPayment strategy configured for email: " + email);
    }

    @Override
    public boolean pay(double amount) {
        // Simulate PayPal payment processing
        System.out.println("Processing PayPal payment of $" + String.format("%.2f", amount) +
                " for user " + email);
        // Simulate successful payment
        System.out.println("PayPal payment SUCCESSFUL.");
        return true;
    }

    @Override
    public String getPaymentMethodName() {
        return "PayPal";
    }
}
