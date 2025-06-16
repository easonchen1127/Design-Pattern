package com.solid.ocp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {
    @Test
    void testCalculateArea() {
        Circle circle = new Circle(7);
        assertEquals(Math.PI * 7 * 7, circle.calculateArea(), 0.001);
    }

    @Test
    void testInvalidRadiusThrowsException() {
        assertThrows(IllegalArgumentException.class, new Executable() {
            public void execute() throws Throwable {
                new Circle(0);
            }
        });
        assertThrows(IllegalArgumentException.class, new Executable() {
            public void execute() throws Throwable {
                new Circle(-5);
            }
        });
    }
}
