package com.patterns.behavioral.command;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LightTest {
    @Test
    void on_turnsLightOn() {
        Light light = new Light("Test Room");
        assertFalse(light.isOn());
        light.on();
        assertTrue(light.isOn());
    }

    @Test
    void off_turnsLightOff() {
        Light light = new Light("Test Room");
        light.on(); // Turn it on first
        assertTrue(light.isOn());
        light.off();
        assertFalse(light.isOn());
    }
}
