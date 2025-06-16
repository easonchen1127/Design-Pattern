package com.patterns.structural.bridge;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TVTest {
    @Test
    void tvOperations() {
        Device tv = new TV();
        assertFalse(tv.isEnabled());
        tv.enable();
        assertTrue(tv.isEnabled());
        tv.setVolume(50);
        assertEquals(50, tv.getVolume());
        tv.setChannel(5);
        assertEquals(5, tv.getChannel());
        tv.disable();
        assertFalse(tv.isEnabled());
    }
}
