package com.patterns.structural.proxy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RealImageTest {
    @Test
    void constructor_loadsImageAndSetsFileName() {
        // This test will experience the simulated delay from loadImageFromDisk
        RealImage image = new RealImage("test_image.jpg");
        assertNotNull(image);
        assertEquals("test_image.jpg", image.getFileName());
        // We can't easily test the 'content' without exposing it or capturing System.out
        // For now, we just check that construction and getFileName work.
    }

    @Test
    void display_doesNotThrowException() {
        RealImage image = new RealImage("display_test.png");
        assertDoesNotThrow(image::display);
    }
}
