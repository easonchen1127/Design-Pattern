package com.patterns.creational.abstractfactory;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WindowsGUIFactoryTest {
    private final GUIFactory factory = new WindowsGUIFactory();

    @Test
    void createButton_shouldReturnWindowsButton() {
        Button button = factory.createButton();
        assertNotNull(button);
        assertTrue(button instanceof WindowsButton, "Button should be an instance of WindowsButton");
    }

    @Test
    void createTextField_shouldReturnWindowsTextField() {
        TextField textField = factory.createTextField();
        assertNotNull(textField);
        assertTrue(textField instanceof WindowsTextField, "TextField should be an instance of WindowsTextField");
    }
}
