package com.patterns.behavioral.command;

// ConcreteCommand: Implements Command and binds an action with a Receiver.
public class LightOnCommand implements Command {
    private Light light; // The receiver

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off(); // Undo for "on" is "off"
    }
}
