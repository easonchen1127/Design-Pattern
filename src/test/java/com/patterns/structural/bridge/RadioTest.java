package com.patterns.structural.bridge;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    @Test
    void radioOperations() {
        Device radio = new Radio();
        assertFalse(radio.isEnabled());
        radio.enable();
        assertTrue(radio.isEnabled());
        radio.setVolume(70);
        assertEquals(70, radio.getVolume());
        radio.setChannel(101); // Sets frequency
        assertEquals(101, radio.getChannel());
        radio.disable();
        assertFalse(radio.isEnabled());
    }
}
