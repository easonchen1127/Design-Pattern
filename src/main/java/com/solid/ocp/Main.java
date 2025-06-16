package com.solid.ocp;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AreaCalculator calculator = new AreaCalculator();

        Shape rectangle = new Rectangle(5, 10); // Area = 50
        Shape circle = new Circle(7);         // Area = PI * 7*7 = ~153.938

        System.out.println("Area of Rectangle: " + calculator.calculateSingleShapeArea(rectangle));
        System.out.println("Area of Circle: " + calculator.calculateSingleShapeArea(circle));

        // Now let's add a new shape (Triangle) without changing AreaCalculator
        Shape triangle = new Triangle(6, 8); // Area = 0.5 * 6 * 8 = 24
        System.out.println("Area of Triangle: " + calculator.calculateSingleShapeArea(triangle));


        List<Shape> shapes = new ArrayList<Shape>();
        shapes.add(rectangle);
        shapes.add(circle);
        shapes.add(triangle); // Add the new shape to the list

        double totalArea = calculator.calculateTotalArea(shapes);
        System.out.println("Total area of all shapes: " + totalArea);
        // Expected total: 50 + 153.938... + 24 = ~227.938
    }
}
