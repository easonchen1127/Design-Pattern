package com.patterns.behavioral.command;

// Receiver: Knows how to perform the operations associated with carrying out a request.
public class Light {
    private String location;
    private boolean isOn = false;

    public Light(String location) {
        this.location = location;
    }

    public void on() {
        isOn = true;
        System.out.println(location + " light is ON");
    }

    public void off() {
        isOn = false;
        System.out.println(location + " light is OFF");
    }

    public boolean isOn() {
        return isOn;
    }

    public String getLocation() {
        return location;
    }
}
