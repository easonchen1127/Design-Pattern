package com.patterns.creational.prototype;

public class Circle extends Shape {
    private int radius;

    public Circle() {
        this.type = "Circle";
    }

    public Circle(Circle target) { // Copy constructor (alternative for deep copy or controlled copy)
        super(); // Call super for potential common fields in Shape (like id, if not handled by clone)
        if (target != null) {
            this.type = target.type;
            this.color = target.color;
            this.radius = target.radius;
            // Note: id is not copied here, assuming new clone gets a new id or it's set externally
        }
    }


    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a " + (color != null ? color + " " : "") + type +
                " with radius " + radius + (getId() != null ? " (ID: " + getId() + ")" : ""));
    }

    // Overriding clone for more specific return type and potentially deeper cloning if needed
    @Override
    public Shape clone() {
        // Using Object.clone() which performs a shallow copy.
        // For primitives and immutable Strings, shallow copy is fine.
        // If Circle had mutable object fields, we'd need to deep copy them here.
        Circle circleClone = (Circle) super.clone();
        // For this example, shallow copy by super.clone() is sufficient for radius (int)
        // If radius was a mutable object, we'd do:
        // circleClone.radiusObject = this.radiusObject.clone();
        return circleClone;
    }
}
