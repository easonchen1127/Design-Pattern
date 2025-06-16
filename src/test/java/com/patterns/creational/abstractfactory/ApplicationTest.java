package com.patterns.creational.abstractfactory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ApplicationTest {

    @Mock
    private GUIFactory mockFactory;
    @Mock
    private Button mockButton;
    @Mock
    private TextField mockTextField;

    @Test
    void constructor_shouldCreateUIElementsUsingFactory() {
        // Arrange: Configure the mock factory to return mock products
        when(mockFactory.createButton()).thenReturn(mockButton);
        when(mockFactory.createTextField()).thenReturn(mockTextField);

        // Act: Create the application with the mock factory
        Application app = new Application(mockFactory);

        // Assert: Verify that the factory methods were called
        verify(mockFactory, times(1)).createButton();
        verify(mockFactory, times(1)).createTextField();
    }

    @Test
    void run_shouldPaintButtonAndRenderTextField() {
        when(mockFactory.createButton()).thenReturn(mockButton);
        when(mockFactory.createTextField()).thenReturn(mockTextField);
        Application app = new Application(mockFactory);

        app.run();

        verify(mockButton, times(1)).paint();
        verify(mockTextField, times(1)).render();
    }

    @Test
    void simulateButtonClick_shouldCallOnClickOnButton() {
        when(mockFactory.createButton()).thenReturn(mockButton);
        when(mockFactory.createTextField()).thenReturn(mockTextField); // Still need to satisfy constructor
        Application app = new Application(mockFactory);
        String event = "Test Click";

        app.simulateButtonClick(event);

        verify(mockButton, times(1)).onClick(event);
    }

    @Test
    void simulateTextFieldInput_shouldCallOnInputAndGetText() {
        when(mockFactory.createButton()).thenReturn(mockButton); // Still need to satisfy constructor
        when(mockFactory.createTextField()).thenReturn(mockTextField);
        Application app = new Application(mockFactory);
        String inputText = "Hello Abstract Factory";
        when(mockTextField.getText()).thenReturn(inputText); // Stub getText for verification

        app.simulateTextFieldInput(inputText);

        verify(mockTextField, times(1)).onInput(inputText);
        verify(mockTextField, times(1)).getText(); // To print the current value
    }
}
