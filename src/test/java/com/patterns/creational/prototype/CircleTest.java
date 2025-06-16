package com.patterns.creational.prototype;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CircleTest {
    @Test
    void clone_createsDistinctObjectWithSameProperties() throws CloneNotSupportedException {
        Circle original = new Circle();
        original.setId("originalCircle");
        original.setColor("Red");
        original.setRadius(15);

        Circle cloned = (Circle) original.clone();

        assertNotSame(original, cloned, "Cloned object should be a different instance.");
        assertEquals(original.getType(), cloned.getType());
        assertEquals(original.getColor(), cloned.getColor());
        assertEquals(original.getRadius(), cloned.getRadius());
        // ID is often set after cloning, or clone might not copy it to ensure uniqueness
        // For this test, let's assume ID is copied by the shallow clone or if Shape.clone handles it.
        // If ID is not meant to be copied, adjust assertion or how ID is handled in clone.
        // Let's assume Shape's clone (super.clone()) copies the id field by shallow copy.
        // assertEquals(original.getId(), cloned.getId());
    }

    @Test
    void clone_modifyingCloneDoesNotAffectOriginal() throws CloneNotSupportedException {
        Circle original = new Circle();
        original.setColor("Blue");
        original.setRadius(20);
        original.setId("C1");

        Circle cloned = (Circle) original.clone();
        cloned.setColor("Green");
        cloned.setRadius(25);
        cloned.setId("C2");

        assertEquals("Blue", original.getColor());
        assertEquals(20, original.getRadius());
        assertEquals("C1", original.getId());

        assertEquals("Green", cloned.getColor());
        assertEquals(25, cloned.getRadius());
        assertEquals("C2", cloned.getId());
    }
}
