package com.patterns.creational.abstractfactory;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MacOSGUIFactoryTest {
    private final GUIFactory factory = new MacOSGUIFactory();

    @Test
    void createButton_shouldReturnMacOSButton() {
        Button button = factory.createButton();
        assertNotNull(button);
        assertTrue(button instanceof MacOSButton, "Button should be an instance of MacOSButton");
    }

    @Test
    void createTextField_shouldReturnMacOSTextField() {
        TextField textField = factory.createTextField();
        assertNotNull(textField);
        assertTrue(textField instanceof MacOSTextField, "TextField should be an instance of MacOSTextField");
    }
}
