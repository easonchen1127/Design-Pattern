package com.solid.lsp;

import java.util.List;

public class BirdFeeder {

    // This method expects any Bird passed to it to behave as a Bird
    // If the initial Bird class had fly(), and Penguin threw an exception, this would be problematic.
    public void makeBirdsFly(List<Bird> birds) {
        System.out.println("\n--- Attempting to make birds fly (Initial Design Problem Demo) ---");
        for (Bird bird : birds) {
            try {
                // This line assumes the initial Bird class with an abstract fly() method.
                // If we were using the refactored Bird (without fly()), this method wouldn't compile
                // unless we cast or check instance of, which we want to avoid if using LSP correctly.
                // For demonstration of the LSP *problem*, we'll assume the first Bird design.
                // To use this method with the first design, Bird.fly() must be abstract.
                // For the refactored design, this method is no longer suitable for *all* birds.
                if (bird instanceof FlyingBird) { // With refactored design, we'd check the interface
                    ((FlyingBird) bird).fly();
                } else {
                    System.out.println(bird.getName() + " cannot fly (or is not a FlyingBird type).");
                }
            } catch (UnsupportedOperationException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }

    // This method works well with the refactored design (using FlyingBird interface)
    public void makeOnlyFlyingBirdsFly(List<FlyingBird> flyingBirds) {
        System.out.println("\n--- Making only FLYING birds fly (Refactored Design) ---");
        for (FlyingBird bird : flyingBirds) {
            bird.fly(); // No try-catch needed, no unexpected behavior.
        }
    }

    public void feedAllBirds(List<Bird> birds) {
        System.out.println("\n--- Feeding all birds ---");
        for (Bird bird : birds) {
            bird.eat(); // eat() is a safe method for all birds.
        }
    }
}
