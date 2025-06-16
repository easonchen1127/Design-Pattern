package com.patterns.creational.prototype;

public class Main {
    public static void main(String[] args) {
        ShapeCache.loadCache(); // Load prototypes

        try {
            System.out.println("--- Creating shapes from prototypes ---");

            Shape clonedCircle1 = ShapeCache.getShape("1");
            if (clonedCircle1 != null) {
                clonedCircle1.setId("C101"); // Customize the clone
                clonedCircle1.draw();
            }

            Shape clonedRectangle1 = ShapeCache.getShape("2");
            if (clonedRectangle1 != null) {
                clonedRectangle1.setId("R201");
                ((Rectangle) clonedRectangle1).setWidth(25); // Modify specific properties
                clonedRectangle1.draw();
            }

            Shape clonedCircle2 = ShapeCache.getShape("1"); // Get another clone of the same prototype
            if (clonedCircle2 != null) {
                clonedCircle2.setId("C102");
                clonedCircle2.setColor("Green"); // Different color
                ((Circle) clonedCircle2).setRadius(5);
                clonedCircle2.draw();
            }

            System.out.println("\n--- Verifying clones are different objects ---");
            if (clonedCircle1 != null && clonedCircle2 != null) {
                System.out.println("clonedCircle1 == clonedCircle2: " + (clonedCircle1 == clonedCircle2)); // false
                System.out.println("clonedCircle1.getClass() == clonedCircle2.getClass(): " +
                        (clonedCircle1.getClass() == clonedCircle2.getClass())); // true
            }

            Shape originalCircle = ShapeCache.getShape("1"); // Accessing original prototype (for demo)
            if (originalCircle != null && clonedCircle1 != null) {
                System.out.println("originalCircle == clonedCircle1: " + (originalCircle == clonedCircle1)); // false
                System.out.println("Original Circle ID before clone modification: " + originalCircle.getId());
                System.out.println("Original Circle Color: " + originalCircle.getColor());
                originalCircle.draw(); // Prototype remains unchanged
            }


        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
