package com.patterns.structural.decorator;

public class WhippedCreamDecorator extends CoffeeDecorator {
    public WhippedCreamDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", with Whipped Cream";
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.75; // Cost of whipped cream
    }
}
