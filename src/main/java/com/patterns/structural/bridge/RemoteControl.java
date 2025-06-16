package com.patterns.structural.bridge;

// Abstraction: Defines the abstraction's interface.
// Maintains a reference to an object of type Implementor.
public abstract class RemoteControl {
    protected Device device; // Reference to the implementor

    protected RemoteControl(Device device) {
        if (device == null) {
            throw new IllegalArgumentException("Device cannot be null for RemoteControl.");
        }
        this.device = device;
    }

    public void togglePower() {
        if (device.isEnabled()) {
            device.disable();
        } else {
            device.enable();
        }
    }

    public void volumeUp() {
        if (device.isEnabled()) {
            device.setVolume(device.getVolume() + 5);
        } else {
            System.out.println("Cannot adjust volume. Device is OFF.");
        }
    }

    public void volumeDown() {
        if (device.isEnabled()) {
            device.setVolume(device.getVolume() - 5);
        } else {
            System.out.println("Cannot adjust volume. Device is OFF.");
        }
    }

    public void channelUp() {
        if (device.isEnabled()) {
            device.setChannel(device.getChannel() + 1);
        } else {
            System.out.println("Cannot change channel. Device is OFF.");
        }
    }

    public void channelDown() {
        if (device.isEnabled()) {
            device.setChannel(device.getChannel() - 1);
        } else {
            System.out.println("Cannot change channel. Device is OFF.");
        }
    }

    public void displayStatus() {
        System.out.println("Remote Status -> " + device.getStatus());
    }
}
