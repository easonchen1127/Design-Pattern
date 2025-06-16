package com.patterns.structural.bridge;

// ConcreteImplementorA
public class TV implements Device {
    private boolean on = false;
    private int volume = 30;
    private int channel = 1;
    private String deviceName = "Television";

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
    public int getChannel() {
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
        System.out.println(deviceName + " channel set to " + channel + ".");
    }

    @Override
    public String getStatus() {
        return deviceName + " is " + (on ? "ON" : "OFF") +
                ", Volume: " + volume + "%, Channel: " + channel;
    }
}
