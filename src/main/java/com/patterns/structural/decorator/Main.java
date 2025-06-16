package com.patterns.structural.decorator;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Ordering Coffees ---");

        // Order a simple coffee
        Coffee simpleCoffee = new SimpleCoffee();
        System.out.println("Order 1: " + simpleCoffee.getDescription() + ", Cost: $" + String.format("%.2f", simpleCoffee.getCost()));

        // Order a coffee with milk
        Coffee milkCoffee = new MilkDecorator(new SimpleCoffee());
        System.out.println("Order 2: " + milkCoffee.getDescription() + ", Cost: $" + String.format("%.2f", milkCoffee.getCost()));

        // Order a coffee with milk and sugar
        Coffee milkAndSugarCoffee = new SugarDecorator(new MilkDecorator(new SimpleCoffee()));
        System.out.println("Order 3: " + milkAndSugarCoffee.getDescription() + ", Cost: $" + String.format("%.2f", milkAndSugarCoffee.getCost()));

        // Order a coffee with milk, sugar, and whipped cream
        Coffee deluxeCoffee = new WhippedCreamDecorator(new SugarDecorator(new MilkDecorator(new SimpleCoffee())));
        System.out.println("Order 4: " + deluxeCoffee.getDescription() + ", Cost: $" + String.format("%.2f", deluxeCoffee.getCost()));

        // Order a coffee with just whipped cream
        Coffee whippedCoffee = new WhippedCreamDecorator(new SimpleCoffee());
        System.out.println("Order 5: " + whippedCoffee.getDescription() + ", Cost: $" + String.format("%.2f", whippedCoffee.getCost()));

        System.out.println("\n--- Attempting to decorate a null coffee (should fail) ---");
        try {
            Coffee badOrder = new MilkDecorator(null);
            System.out.println(badOrder.getDescription());
        } catch (IllegalArgumentException e) {
            System.err.println("Error creating decorated coffee: " + e.getMessage());
        }
    }
}
