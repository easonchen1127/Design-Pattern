package com.patterns.structural.facade;

public class DvdPlayer {
    private String description;
    private String movie;
    private boolean isOn;

    public DvdPlayer(String description) {
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

    public void play(String movie) {
        this.movie = movie;
        System.out.println(description + " playing \"" + movie + "\"");
    }

    public void stop() {
        System.out.println(description + " stopped \"" + movie + "\"");
    }

    public void eject() {
        System.out.println(description + " ejecting DVD");
        movie = null;
    }

    public boolean isOn() { return isOn; }
    public String getPlayingMovie() { return movie; }
}
