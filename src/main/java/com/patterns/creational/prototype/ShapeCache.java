package com.patterns.creational.prototype;

import java.util.Hashtable;

public class ShapeCache {
    private static Hashtable<String, Shape> shapeMap = new Hashtable<>();

    public static Shape getShape(String shapeId) throws CloneNotSupportedException {
        Shape cachedShape = shapeMap.get(shapeId);
        if (cachedShape == null) {
            return null; // Or throw exception if shapeId must exist
        }
        // Return a clone of the cached shape
        return (Shape) cachedShape.clone();
    }

    // Load initial prototypes into the cache
    // This would typically be done once, perhaps during application startup
    public static void loadCache() {
        Circle circle = new Circle();
        circle.setId("1");
        circle.setColor("Red"); // Default color for prototype
        circle.setRadius(10);
        shapeMap.put(circle.getId(), circle);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("2");
        rectangle.setColor("Blue"); // Default color for prototype
        rectangle.setWidth(20);
        rectangle.setHeight(15);
        shapeMap.put(rectangle.getId(), rectangle);

        System.out.println("Shape cache loaded with prototypes.");
    }
}
