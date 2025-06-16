package com.patterns.creational.abstractfactory;

public class MacOSButton implements Button {
    @Override
    public void paint() {
        System.out.println("Painting a macOS-style button (Aqua).");
    }

    @Override
    public void onClick(String event) {
        System.out.println("MacOSButton clicked. Event: " + event);
    }
}
