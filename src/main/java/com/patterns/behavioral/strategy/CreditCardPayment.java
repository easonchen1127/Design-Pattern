package com.patterns.behavioral.strategy;

// ConcreteStrategy A
public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolderName;
    private String cvv;
    private String expiryDate;

    public CreditCardPayment(String cardNumber, String cardHolderName, String cvv, String expiryDate) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
        System.out.println("CreditCardPayment strategy configured for card: " + maskCardNumber(cardNumber));
    }

    private String maskCardNumber(String number) {
        if (number == null || number.length() <= 4) return number;
        return "**** **** **** " + number.substring(number.length() - 4);
    }

    @Override
    public boolean pay(double amount) {
        // Simulate credit card payment processing
        System.out.println("Processing credit card payment of $" + String.format("%.2f", amount) +
                " with card " + maskCardNumber(cardNumber));
        if (amount > 10000) { // Simulate a transaction limit for demo
            System.out.println("Credit card payment FAILED (amount exceeds limit).");
            return false;
        }
        System.out.println("Credit card payment SUCCESSFUL.");
        return true;
    }

    @Override
    public String getPaymentMethodName() {
        return "Credit Card";
    }
}
