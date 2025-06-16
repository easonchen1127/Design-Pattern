package com.patterns.creational.abstractfactory;

public interface GUIFactory {
    Button createButton();
    TextField createTextField();
    // Could add createCheckbox(), createMenu(), etc. for a full GUI family
}
