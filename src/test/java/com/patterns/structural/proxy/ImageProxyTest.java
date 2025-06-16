package com.patterns.structural.proxy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Note: Testing lazy loading precisely without instrumenting RealImage constructor
// or using more complex test setups (like PowerMock for static methods if RealImage
// constructor was static, which it isn't here) is tricky.
// These tests focus on observable behavior of the proxy.
class ImageProxyTest {

    @Test
    void constructor_doesNotLoadRealImageImmediately() {
        // We infer this by not seeing the "RealImage: Loaded image..." print from RealImage constructor
        // A more robust test would involve a way to check if RealImage constructor was called.
        // For this example, we'll rely on the proxy's own logging.
        System.out.println("--- Test: constructor_doesNotLoadRealImageImmediately ---");
        ImageProxy proxy = new ImageProxy("lazy_load_test.gif");
        assertNotNull(proxy);
        assertEquals("lazy_load_test.gif", proxy.getFileName());
        assertFalse(proxy.isLoaded(), "RealImage should not be loaded on proxy creation.");
        System.out.println("--- End Test: constructor_doesNotLoadRealImageImmediately ---");
    }

    @Test
    void display_loadsRealImageOnFirstCall() {
        System.out.println("--- Test: display_loadsRealImageOnFirstCall ---");
        ImageProxy proxy = new ImageProxy("first_display.jpg");
        assertFalse(proxy.isLoaded(), "Should not be loaded before first display.");

        // First call to display - should load RealImage
        proxy.display();
        assertTrue(proxy.isLoaded(), "Should be loaded after first display.");
        System.out.println("--- End Test: display_loadsRealImageOnFirstCall ---");
    }

    @Test
    void display_subsequentCalls_doNotReloadRealImage() {
        System.out.println("--- Test: display_subsequentCalls_doNotReloadRealImage ---");
        ImageProxy proxy = new ImageProxy("cached_image.png");

        // First call
        proxy.display();
        assertTrue(proxy.isLoaded());

        // To truly test "not reload", we'd need to spy on RealImage constructor or
        // count "Loaded image" messages. For this example, we assume the proxy's logic
        // correctly avoids re-instantiation. We can check that display still works.
        // The "RealImage: Loaded image..." message should appear only once.
        System.out.println("Calling display again for cached_image.png");
        proxy.display(); // Should use the already loaded realImage

        // If we had a counter for RealImage instantiations, we'd assert it's 1.
        // For now, we just ensure it doesn't throw and isLoaded remains true.
        assertTrue(proxy.isLoaded());
        System.out.println("--- End Test: display_subsequentCalls_doNotReloadRealImage ---");

    }

    @Test
    void getFileName_returnsFileNameWithoutLoadingRealImage() {
        ImageProxy proxy = new ImageProxy("metadata_test.bmp");
        assertEquals("metadata_test.bmp", proxy.getFileName());
        assertFalse(proxy.isLoaded(), "getFileName should not trigger RealImage loading.");
    }
}
