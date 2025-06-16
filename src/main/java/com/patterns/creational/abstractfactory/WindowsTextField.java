package com.patterns.creational.abstractfactory;

public class WindowsTextField implements TextField {
    private String text = "";

    @Override
    public void render() {
        System.out.println("Rendering a Windows-style text field.");
    }

    @Override
    public void onInput(String text) {
        this.text = text;
        System.out.println("WindowsTextField input: " + text);
    }

    @Override
    public String getText() {
        return text;
    }
}
