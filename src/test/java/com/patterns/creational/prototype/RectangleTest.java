package com.patterns.creational.prototype;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
    @Test
    void clone_createsDistinctObjectWithSameProperties() throws CloneNotSupportedException {
        Rectangle original = new Rectangle();
        original.setId("originalRect");
        original.setColor("Green");
        original.setWidth(10);
        original.setHeight(20);

        Rectangle cloned = (Rectangle) original.clone();

        assertNotSame(original, cloned);
        assertEquals(original.getType(), cloned.getType());
        assertEquals(original.getColor(), cloned.getColor());
        assertEquals(original.getWidth(), cloned.getWidth());
        assertEquals(original.getHeight(), cloned.getHeight());
    }
}
