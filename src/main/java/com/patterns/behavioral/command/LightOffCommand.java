package com.patterns.behavioral.command;

public class LightOffCommand implements Command {
    private Light light; // The receiver

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on(); // Undo for "off" is "on"
    }
}
