package com.patterns.structural.decorator;

// Decorator: Maintains a reference to a Component object and defines an interface
// that conforms to Component's interface.
public abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee; // The component being decorated

    public CoffeeDecorator(Coffee decoratedCoffee) {
        if (decoratedCoffee == null) {
            throw new IllegalArgumentException("Decorated coffee cannot be null.");
        }
        this.decoratedCoffee = decoratedCoffee;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription(); // Delegates to the wrapped component
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost(); // Delegates to the wrapped component
    }
}
