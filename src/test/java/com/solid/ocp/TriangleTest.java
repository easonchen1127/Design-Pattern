package com.solid.ocp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    @Test
    void testCalculateArea() {
        Triangle triangle = new Triangle(6, 8);
        assertEquals(24.0, triangle.calculateArea(), 0.001); // 0.5 * 6 * 8
    }

    @Test
    void testInvalidDimensionsThrowsException() {
        assertThrows(IllegalArgumentException.class, new Executable() {
            public void execute() throws Throwable {
                new Triangle(0, 8);
            }
        });
        assertThrows(IllegalArgumentException.class, new Executable() {
            public void execute() throws Throwable {
                new Triangle(6, -1);
            }
        });
    }
}
