package com.patterns.creational.abstractfactory;

public class MacOSTextField implements TextField {
    private String text = "";

    @Override
    public void render() {
        System.out.println("Rendering a macOS-style text field (Aqua).");
    }

    @Override
    public void onInput(String text) {
        this.text = text;
        System.out.println("MacOSTextField input: " + text);
    }

    @Override
    public String getText() {
        return text;
    }
}
