package com.patterns.creational.abstractfactory;

public interface TextField {
    void render();
    void onInput(String text);
    String getText();
}
