package com.patterns.behavioral.strategy;

// Strategy Interface
public interface PaymentStrategy {
    boolean pay(double amount); // Returns true if payment is successful
    String getPaymentMethodName();
}
