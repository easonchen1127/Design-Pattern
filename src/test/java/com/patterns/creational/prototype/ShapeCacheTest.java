package com.patterns.creational.prototype;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShapeCacheTest {

    @BeforeAll
    static void setUpCache() {
        ShapeCache.loadCache(); // Ensure cache is loaded once for all tests in this class
    }

    @Test
    void getShape_returnsClonedCircle() throws CloneNotSupportedException {
        Shape circle1 = ShapeCache.getShape("1");
        Shape circle2 = ShapeCache.getShape("1");

        assertNotNull(circle1);
        assertTrue(circle1 instanceof Circle);
        assertEquals("Red", circle1.getColor(), "Default color for prototype circle should be Red");

        assertNotNull(circle2);
        assertNotSame(circle1, circle2, "getShape should return a clone, not the same instance.");
        assertEquals(circle1.getType(), circle2.getType());
    }

    @Test
    void getShape_returnsClonedRectangle() throws CloneNotSupportedException {
        Shape rect1 = ShapeCache.getShape("2");
        Shape rect2 = ShapeCache.getShape("2");

        assertNotNull(rect1);
        assertTrue(rect1 instanceof Rectangle);
        assertEquals("Blue", rect1.getColor(), "Default color for prototype rectangle should be Blue");


        assertNotNull(rect2);
        assertNotSame(rect1, rect2);
        assertEquals(rect1.getType(), rect2.getType());
    }

    @Test
    void getShape_nonExistentId_returnsNull() throws CloneNotSupportedException {
        Shape nonExistent = ShapeCache.getShape("99");
        assertNull(nonExistent);
    }

    @Test
    void getShape_modifyingCloneDoesNotAffectCachedPrototype() throws CloneNotSupportedException {
        Shape originalPrototypeCircle = ShapeCache.getShape("1"); // Access internal map for this test
        String originalColor = originalPrototypeCircle.getColor();
        int originalRadius = ((Circle)originalPrototypeCircle).getRadius();


        Shape clonedCircle = ShapeCache.getShape("1");
        clonedCircle.setColor("Yellow");
        ((Circle)clonedCircle).setRadius(500);

        // Verify the original prototype in the cache is unchanged
        Shape reRetrievedPrototypeCircle = ShapeCache.getShape("1");
        assertEquals(originalColor, reRetrievedPrototypeCircle.getColor());
        assertEquals(originalRadius, ((Circle)reRetrievedPrototypeCircle).getRadius());
    }
}
