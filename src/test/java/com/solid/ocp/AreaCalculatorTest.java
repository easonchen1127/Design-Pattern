package com.solid.ocp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class) // Important for initializing mocks
class AreaCalculatorTest {

    private AreaCalculator areaCalculator;

    @Mock
    private Shape mockShape1; // Mocking the Shape interface

    @Mock
    private Shape mockShape2;

    @BeforeEach
    void setUp() {
        areaCalculator = new AreaCalculator();
    }

    @Test
    void testCalculateSingleShapeArea() {
        when(mockShape1.calculateArea()).thenReturn(25.0);
        assertEquals(25.0, areaCalculator.calculateSingleShapeArea(mockShape1), 0.001);
        verify(mockShape1, times(1)).calculateArea();
    }

    @Test
    void testCalculateSingleShapeAreaWithNullShapeThrowsException() {
        assertThrows(IllegalArgumentException.class, new Executable() {
            public void execute() throws Throwable {
                areaCalculator.calculateSingleShapeArea(null);
            }
        });
    }

    @Test
    void testCalculateTotalAreaWithMultipleShapes() {
        when(mockShape1.calculateArea()).thenReturn(20.0);
        when(mockShape2.calculateArea()).thenReturn(30.0);

        List<Shape> shapes = Arrays.asList(mockShape1, mockShape2);
        assertEquals(50.0, areaCalculator.calculateTotalArea(shapes), 0.001);

        verify(mockShape1, times(1)).calculateArea();
        verify(mockShape2, times(1)).calculateArea();
    }

    @Test
    void testCalculateTotalAreaWithEmptyList() {
        assertEquals(0.0, areaCalculator.calculateTotalArea(Collections.emptyList()), 0.001);
    }

    @Test
    void testCalculateTotalAreaWithNullList() {
        assertEquals(0.0, areaCalculator.calculateTotalArea(null), 0.001);
    }

    @Test
    void testCalculateTotalAreaWithListContainingNullShape() {
        when(mockShape1.calculateArea()).thenReturn(15.0);
        List<Shape> shapes = Arrays.asList(mockShape1, null, mockShape2); // mockShape2 will not be called for area
        when(mockShape2.calculateArea()).thenReturn(10.0); // Set up behavior even if not expected to be called in this specific list order

        // Only mockShape1's area should be counted.
        // If mockShape2 was before null, its area would be counted too.
        // The loop in AreaCalculator skips nulls.
        assertEquals(25.0, areaCalculator.calculateTotalArea(shapes), 0.001);
        verify(mockShape1, times(1)).calculateArea();
        verify(mockShape2, times(1)).calculateArea(); // It's called as it's in the list after null
    }

    @Test
    void testCalculateTotalAreaWithRealShapesDemonstratingOCP() {
        // This test uses real shapes to emphasize OCP
        Shape rectangle = new Rectangle(2, 3); // Area 6
        Shape circle = new Circle(1);          // Area PI (~3.14159)
        Shape triangle = new Triangle(4, 5);   // Area 10

        List<Shape> shapes = Arrays.asList(rectangle, circle, triangle);
        double expectedTotalArea = 6.0 + Math.PI + 10.0;

        assertEquals(expectedTotalArea, areaCalculator.calculateTotalArea(shapes), 0.001);
    }
}
