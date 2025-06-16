package com.solid.ocp;

import java.util.List;

public class AreaCalculator {

    // This method is closed for modification.
    // It works with any object that implements the Shape interface.
    public double calculateTotalArea(List<Shape> shapes) {
        if (shapes == null) {
            return 0;
        }
        double totalArea = 0;
        for (Shape shape : shapes) {
            if (shape != null) { // Defensive check
                totalArea += shape.calculateArea();
            }
        }
        return totalArea;
    }

    // We could also have a method for a single shape if needed
    public double calculateSingleShapeArea(Shape shape) {
        if (shape == null) {
            throw new IllegalArgumentException("Shape cannot be null.");
        }
        return shape.calculateArea();
    }
}
