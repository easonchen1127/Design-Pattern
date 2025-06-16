package com.patterns.structural.bridge;

// ConcreteImplementorB
public class Radio implements Device {
    private boolean on = false;
    private int volume = 20;
    private int frequency = 98; // Using frequency instead of channel for radio
    private String deviceName = "Radio";

    @Override
    public boolean isEnabled() {
        return on;
    }

    @Override
    public void enable() {
        on = true;
        System.out.println(deviceName + " is now ON.");
    }

    @Override
    public void disable() {
        on = false;
        System.out.println(deviceName + " is now OFF.");
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int percent) {
        if (percent < 0) percent = 0;
        if (percent > 100) percent = 100;
        this.volume = percent;
        System.out.println(deviceName + " volume set to " + volume + "%.");
    }

    @Override
    public int getChannel() { // Adapting "channel" concept for radio's frequency
        return frequency;
    }

    @Override
    public void setChannel(int frequency) { // Interpreting "channel" as frequency
        this.frequency = frequency;
        System.out.println(deviceName + " frequency set to " + frequency + " MHz.");
    }

    @Override
    public String getStatus() {
        return deviceName + " is " + (on ? "ON" : "OFF") +
                ", Volume: " + volume + "%, Frequency: " + frequency + " MHz";
    }
}
