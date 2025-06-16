package com.patterns.creational.abstractfactory;

public class Application {
    private final Button button;
    private final TextField textField;

    // The application is configured with a specific factory
    // ensuring that all created UI elements belong to the same family.
    public Application(GUIFactory factory) {
        System.out.println("Configuring application with a specific GUI style...");
        this.button = factory.createButton();
        this.textField = factory.createTextField();
    }

    public void run() {
        System.out.println("Application running...");
        button.paint();
        textField.render();
    }

    public void simulateButtonClick(String event) {
        button.onClick(event);
    }

    public void simulateTextFieldInput(String text) {
        textField.onInput(text);
        System.out.println("Text field current value: " + textField.getText());
    }
}
