package com.patterns.structural.decorator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CoffeeDecoratorTest {

    @Test
    void milkDecorator_addsToDescriptionAndCost() {
        Coffee simpleCoffee = new SimpleCoffee();
        Coffee milkCoffee = new MilkDecorator(simpleCoffee);

        assertEquals("Simple Coffee, with Milk", milkCoffee.getDescription());
        assertEquals(2.00 + 0.50, milkCoffee.getCost(), 0.001);
    }

    @Test
    void sugarDecorator_addsToDescriptionAndCost() {
        Coffee simpleCoffee = new SimpleCoffee();
        Coffee sugarCoffee = new SugarDecorator(simpleCoffee);

        assertEquals("Simple Coffee, with Sugar", sugarCoffee.getDescription());
        assertEquals(2.00 + 0.25, sugarCoffee.getCost(), 0.001);
    }

    @Test
    void whippedCreamDecorator_addsToDescriptionAndCost() {
        Coffee simpleCoffee = new SimpleCoffee();
        Coffee whippedCoffee = new WhippedCreamDecorator(simpleCoffee);

        assertEquals("Simple Coffee, with Whipped Cream", whippedCoffee.getDescription());
        assertEquals(2.00 + 0.75, whippedCoffee.getCost(), 0.001);
    }

    @Test
    void multipleDecorators_accumulateDescriptionAndCost() {
        Coffee coffee = new SimpleCoffee();
        coffee = new MilkDecorator(coffee);
        coffee = new SugarDecorator(coffee);
        coffee = new WhippedCreamDecorator(coffee);

        assertEquals("Simple Coffee, with Milk, with Sugar, with Whipped Cream", coffee.getDescription());
        assertEquals(2.00 + 0.50 + 0.25 + 0.75, coffee.getCost(), 0.001);
    }

    @Test
    void decorator_withNullCoffee_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new MilkDecorator(null));
    }

    @Test
    void decoratorOrderMattersForDescription_butNotForCostSum() {
        Coffee coffee1 = new SugarDecorator(new MilkDecorator(new SimpleCoffee()));
        // Description: Simple Coffee, with Milk, with Sugar
        // Cost: 2.00 + 0.50 + 0.25 = 2.75

        Coffee coffee2 = new MilkDecorator(new SugarDecorator(new SimpleCoffee()));
        // Description: Simple Coffee, with Sugar, with Milk
        // Cost: 2.00 + 0.25 + 0.50 = 2.75

        assertEquals("Simple Coffee, with Milk, with Sugar", coffee1.getDescription());
        assertEquals("Simple Coffee, with Sugar, with Milk", coffee2.getDescription());
        assertEquals(coffee1.getCost(), coffee2.getCost(), 0.001);
        assertEquals(2.75, coffee1.getCost(), 0.001);
    }
}
