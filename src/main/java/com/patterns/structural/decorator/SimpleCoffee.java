package com.patterns.structural.decorator;

// ConcreteComponent: Defines an object to which additional responsibilities can be attached.
public class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Simple Coffee";
    }

    @Override
    public double getCost() {
        return 2.00; // Base price
    }
}
