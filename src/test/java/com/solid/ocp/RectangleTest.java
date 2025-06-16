package com.solid.ocp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
    @Test
    void testCalculateArea() {
        Rectangle rectangle = new Rectangle(5, 10);
        assertEquals(50.0, rectangle.calculateArea(), 0.001);
    }

    @Test
    void testInvalidDimensionsThrowsException() {
        assertThrows(IllegalArgumentException.class, new Executable() {
            public void execute() throws Throwable {
                new Rectangle(0, 10);
            }
        });
        assertThrows(IllegalArgumentException.class, new Executable() {
            public void execute() throws Throwable {
                new Rectangle(5, -1);
            }
        });
    }
}
