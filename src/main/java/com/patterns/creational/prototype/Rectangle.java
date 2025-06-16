package com.patterns.creational.prototype;

public class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle() {
        this.type = "Rectangle";
    }

    public Rectangle(Rectangle target) { // Copy constructor
        super();
        if (target != null) {
            this.type = target.type;
            this.color = target.color;
            this.width = target.width;
            this.height = target.height;
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a " + (color != null ? color + " " : "") + type +
                " with width " + width + " and height " + height +
                (getId() != null ? " (ID: " + getId() + ")" : ""));
    }

    @Override
    public Shape clone() {
        Rectangle rectangleClone = (Rectangle) super.clone();
        // Shallow copy is fine for width and height (int)
        return rectangleClone;
    }
}
