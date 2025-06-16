package com.patterns.structural.facade;

public class TheaterLights {
    private String description;

    public TheaterLights(String description) {
        this.description = description;
    }

    public void dim(int level) {
        System.out.println(description + " dimming to " + level + "%");
    }

    public void on() {
        System.out.println(description + " are ON (100%)");
    }
}
