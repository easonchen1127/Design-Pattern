package com.patterns.creational.prototype;

// Prototype Interface (or Abstract Class)
public abstract class Shape implements Cloneable { // Implementing Cloneable for Object.clone()
    private String id;
    protected String type;
    protected String color; // Example of a property that might be copied

    public abstract void draw();

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // The clone method
    // Using Object.clone() for a shallow copy. For deep copy, more work is needed.
    @Override
    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone(); // Performs a shallow copy
        } catch (CloneNotSupportedException e) {
            // This should not happen because we are implementing Cloneable
            e.printStackTrace();
        }
        return clone;
    }
}
