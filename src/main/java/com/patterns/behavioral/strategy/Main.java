package com.patterns.behavioral.strategy;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem(new Item("Laptop Pro", 1200.00));
        cart.addItem(new Item("Wireless Mouse", 25.00));
        cart.addItem(new Item("Keyboard", 75.00));

        System.out.println("\n--- Attempting checkout with Credit Card ---");
        PaymentStrategy creditCard = new CreditCardPayment("1234-5678-9012-3456", "John Doe", "123", "12/25");
        cart.setPaymentStrategy(creditCard);
        boolean ccSuccess = cart.checkout();
        System.out.println("Credit Card Checkout Successful: " + ccSuccess);

        // Clear cart or create new one for next payment for this demo
        cart = new ShoppingCart(); // New cart for simplicity
        cart.addItem(new Item("E-book Reader", 150.00));
        cart.addItem(new Item("Subscription", 9.99));


        System.out.println("\n--- Attempting checkout with PayPal ---");
        PaymentStrategy payPal = new PayPalPayment("john.doe@example.com", "securePassword123");
        cart.setPaymentStrategy(payPal);
        boolean ppSuccess = cart.checkout();
        System.out.println("PayPal Checkout Successful: " + ppSuccess);


        System.out.println("\n--- Attempting checkout without setting a strategy ---");
        ShoppingCart cartNoStrategy = new ShoppingCart();
        cartNoStrategy.addItem(new Item("Test Item", 10.00));
        boolean noStrategySuccess = cartNoStrategy.checkout();
        System.out.println("No Strategy Checkout Successful: " + noStrategySuccess);

        System.out.println("\n--- Attempting high value checkout with Credit Card (should fail) ---");
        ShoppingCart highValueCart = new ShoppingCart();
        highValueCart.addItem(new Item("Enterprise Software License", 15000.00));
        highValueCart.setPaymentStrategy(creditCard); // Using the same CC instance
        boolean highValueSuccess = highValueCart.checkout();
        System.out.println("High Value CC Checkout Successful: " + highValueSuccess);
    }
}
