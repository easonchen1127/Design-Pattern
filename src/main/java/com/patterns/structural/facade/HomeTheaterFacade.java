package com.patterns.structural.facade;

// Facade: Provides a simplified, unified interface to a set of interfaces in a subsystem.
// Facade defines a higher-level interface that makes the subsystem easier to use.
public class HomeTheaterFacade {
    // Composition: Facade holds references to all subsystem components
    private Amplifier amplifier;
    private DvdPlayer dvdPlayer;
    private Projector projector;
    private Screen screen;
    private TheaterLights lights;

    public HomeTheaterFacade(Amplifier amp, DvdPlayer dvd, Projector proj,
                             Screen scr, TheaterLights lght) {
        this.amplifier = amp;
        this.dvdPlayer = dvd;
        this.projector = proj;
        this.screen = scr;
        this.lights = lght;
        System.out.println("HomeTheaterFacade configured and ready.");
    }

    // Simplified methods that orchestrate subsystem components
    public void watchMovie(String movie) {
        System.out.println("\nGet ready to watch a movie...");
        lights.dim(10);
        screen.down();
        projector.on();
        projector.wideScreenMode();
        amplifier.on();
        amplifier.setSurroundSound();
        amplifier.setVolume(25);
        dvdPlayer.on();
        dvdPlayer.play(movie);
    }

    public void endMovie() {
        System.out.println("\nShutting movie theater down...");
        dvdPlayer.stop();
        dvdPlayer.eject();
        dvdPlayer.off();
        amplifier.off();
        projector.off();
        screen.up();
        lights.on();
    }

    public void listenToMusic() {
        System.out.println("\nGet ready for some music...");
        lights.dim(50); // Different light setting for music
        amplifier.on();
        amplifier.setVolume(30);
        // Assuming DVD player can play CDs or audio
        dvdPlayer.on();
        dvdPlayer.play("Favorite Music Album"); // Or specific CD logic
    }

    public void endMusic() {
        System.out.println("\nTurning off music...");
        dvdPlayer.stop(); // or eject
        dvdPlayer.off();
        amplifier.off();
        lights.on();
    }
}
