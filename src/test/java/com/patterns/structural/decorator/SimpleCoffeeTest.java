package com.patterns.structural.decorator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SimpleCoffeeTest {
    @Test
    void getDescription_returnsCorrectDescription() {
        Coffee coffee = new SimpleCoffee();
        assertEquals("Simple Coffee", coffee.getDescription());
    }

    @Test
    void getCost_returnsCorrectCost() {
        Coffee coffee = new SimpleCoffee();
        assertEquals(2.00, coffee.getCost(), 0.001);
    }
}
