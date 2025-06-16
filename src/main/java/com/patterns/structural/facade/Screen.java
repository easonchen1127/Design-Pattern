package com.patterns.structural.facade;

public class Screen {
    private String description;

    public Screen(String description) {
        this.description = description;
    }

    public void up() {
        System.out.println(description + " going UP");
    }

    public void down() {
        System.out.println(description + " going DOWN");
    }
}
