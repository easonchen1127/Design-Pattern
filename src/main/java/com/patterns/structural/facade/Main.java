package com.patterns.structural.facade;

public class Main {
    public static void main(String[] args) {
        // Instantiate subsystem components
        Amplifier amp = new Amplifier("Top-Notch Amplifier");
        DvdPlayer dvd = new DvdPlayer("Blu-Ray DVD Player");
        Projector projector = new Projector("4K Laser Projector");
        Screen screen = new Screen("Motorized Projection Screen");
        TheaterLights lights = new TheaterLights("Smart Theater Lights");

        // Instantiate the Facade with the subsystem components
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(amp, dvd, projector, screen, lights);

        // Use the simplified interface provided by the Facade
        homeTheater.watchMovie("Inception");
        homeTheater.endMovie();

        System.out.println("\n===================================");

        homeTheater.listenToMusic();
        homeTheater.endMusic();

        // Client doesn't need to know about the individual complexities of
        // turning on projector, lowering screen, dimming lights, setting volume etc.
        // It just calls watchMovie() on the facade.
    }
}
