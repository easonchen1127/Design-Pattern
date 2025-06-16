package com.patterns.creational.abstractfactory;

public class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("Painting a Windows-style button.");
    }

    @Override
    public void onClick(String event) {
        System.out.println("WindowsButton clicked. Event: " + event);
    }
}
