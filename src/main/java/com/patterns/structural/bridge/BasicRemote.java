package com.patterns.structural.bridge;

// RefinedAbstraction: Extends the interface defined by Abstraction.
public class BasicRemote extends RemoteControl {
    public BasicRemote(Device device) {
        super(device);
        System.out.println("BasicRemote configured for device: " + device.getClass().getSimpleName());
    }

    // BasicRemote might not have additional methods beyond RemoteControl,
    // or it might have simpler versions of operations.
    // For this example, it mostly inherits.
    public void simpleAction() {
        System.out.println("BasicRemote: Performing a simple predefined action.");
        if (!device.isEnabled()) device.enable();
        device.setVolume(20); // Example simple action
    }
}
