package com.patterns.structural.facade;

public class Projector {
    private String description;
    private boolean isOn;

    public Projector(String description) {
        this.description = description;
    }

    public void on() {
        isOn = true;
        System.out.println(description + " is ON");
    }

    public void off() {
        isOn = false;
        System.out.println(description + " is OFF");
    }

    public void wideScreenMode() {
        System.out.println(description + " in widescreen mode (16x9 aspect ratio)");
    }

    public boolean isOn() { return isOn; }
}
