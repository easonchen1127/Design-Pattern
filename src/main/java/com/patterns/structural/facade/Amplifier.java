package com.patterns.structural.facade;

public class Amplifier {
    private String description;
    private int volume;
    private boolean isOn;

    public Amplifier(String description) {
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

    public void setVolume(int level) {
        this.volume = level;
        System.out.println(description + " volume set to " + level);
    }

    public void setSurroundSound() {
        System.out.println(description + " surround sound ON (Dolby Atmos)");
    }

    public boolean isOn() { return isOn; }
    public int getVolume() { return volume; }
}
